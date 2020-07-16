package com.hl.childhood.controller;

import com.github.pagehelper.PageHelper;
import com.hl.childhood.module.User;
import com.hl.childhood.properties.ImagePath;
import com.hl.childhood.properties.OssConfig;
import com.hl.childhood.service.UserService;
import com.hl.childhood.util.ImageBase64Converter;
import com.hl.childhood.util.OssUtils;
import com.hl.childhood.vo.dic.DicVO;
import com.hl.childhood.vo.goods.GoodsInfoVO;
import com.hl.childhood.vo.page.PageVO;
import com.hl.childhood.vo.page.ResultsPageVO;
import com.hl.childhood.vo.user.*;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("userController")
@Scope("prototype")
public class UserController extends BaseController {

    @Autowired
    private UserService<User> userService;

    @Autowired
    private ImagePath imagePath;

    @Autowired
    private OssConfig ossConfig;

    /**
     * 个人中心 1. 登录人信息接口
     */
    @GetMapping(value = "/userInfo")
    public Result userInfoGet(HttpServletRequest request) {
        String loginId = getLoginerId(request);
        UserInfoVO vo = userService.getUserInfo(loginId);
        return Result.getSuccResult(vo);
    }

    /**
     * 个人中心 2. 登录人信息修改接口
     * @return
     */
    @PostMapping(value = "/userInfo")
    public Result userInfoPost(HttpServletRequest request, @RequestBody HashMap<String, String> paramMap){
        try {
            String loginId = getLoginerId(request);
            User user = new User();
            user.setUser_id(loginId);
            if(!StringUtils.isEmpty(paramMap.get("user_icon")) && !StringUtils.isEmpty(paramMap.get("user_icon_suffix"))){
                //头像处理
                // 头像图片保存本地，上传OSS，保存数据库
                // base64图片先保存本地临时文件
                String iconPath = imagePath.getLocalPicPath();
                String iconNameLocal = loginId + "_icon." + paramMap.get("user_icon_suffix");
                ImageBase64Converter.convertBase64ToFile(paramMap.get("user_icon"), iconPath, iconNameLocal);
                //再将本地临时文件上传到OSS
                String iconName = "icon." + paramMap.get("user_icon_suffix");
                String icon_remote_path = ossConfig.getUserPath() + loginId + "/icon/" + iconName;
                String user_icon =  OssUtils.uploadOssReturnUrl(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret(),
                        ossConfig.getBucketName(), iconPath + "/" + iconNameLocal, icon_remote_path);

                if(StringUtils.isEmpty(user_icon)){
                    return Result.getFalseResult(ResultCode.FAILURE, "头像上传失败");
                }else{
                    user.setUser_icon(user_icon);
                }
            }
            if(!StringUtils.isEmpty(paramMap.get("user_name"))){
                user.setUser_name(paramMap.get("user_name"));
            }
            if(!StringUtils.isEmpty(paramMap.get("user_sex"))){
                user.setUser_sex(Integer.valueOf(paramMap.get("user_sex")));
            }
            if(!StringUtils.isEmpty(paramMap.get("user_birthday"))){
                user.setUser_birthday(paramMap.get("user_birthday"));
            }
            if(!StringUtils.isEmpty(paramMap.get("user_region"))){
                user.setUser_region(paramMap.get("user_region"));
            }
            userService.updateByPrimaryKey(user);
            return Result.getSuccResult();
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }

    }

    /**
     * 个人中心 3. 登录人金额信息接口
     */
    @GetMapping(value = "/userMoneyInfo")
    public Result userMoneyInfo(HttpServletRequest request) {
        String loginId = getLoginerId(request);
        UserMoneyVO vo = userService.getMoneyInfo(loginId);
        return Result.getSuccResult(vo);
    }

    /**
     * 个人中心 4. 我的优惠券列表接口
     * @return
     */
    @GetMapping(value = "/userCoupons")
    public Result goodsList(HttpServletRequest request, PageVO pageVO){
        List<UserCouponsVO> userCouponsVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        userCouponsVO = userService.getUserCoupns(getLoginerId(request));
        ResultsPageVO resultsPageVO = ResultsPageVO.init(userCouponsVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 个人中心 5. 我的余额记录列表接口
     * @return
     */
    @GetMapping(value = "/userMoneys")
    public Result userMoneys(HttpServletRequest request, PageVO pageVO){
        List<UserMoneyRecordVO> userMoneyRecordVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        userMoneyRecordVO = userService.getUserMoneyRecords(getLoginerId(request));
        ResultsPageVO resultsPageVO = ResultsPageVO.init(userMoneyRecordVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 个人中心 6. 我的积分记录列表接口
     * @return
     */
    @GetMapping(value = "/userScores")
    public Result userScores(HttpServletRequest request, PageVO pageVO){
        List<UserScoreRecordVO> userScoreRecordVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        userScoreRecordVO = userService.getUserScoreRecords(getLoginerId(request));
        ResultsPageVO resultsPageVO = ResultsPageVO.init(userScoreRecordVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 个人中心 7. 我的订单列表接口
     * @return
     */
    @GetMapping(value = "/userOrders")
    public Result userOrders(HttpServletRequest request, PageVO pageVO, String order_status){
        List<UserOrdersVO> userOrdersVO = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        userOrdersVO = userService.getUserOrders(getLoginerId(request), order_status);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(userOrdersVO, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

}

