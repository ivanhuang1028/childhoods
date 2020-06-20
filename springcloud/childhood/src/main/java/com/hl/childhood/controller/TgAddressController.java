package com.hl.childhood.controller;

import com.hl.childhood.module.SearchHis;
import com.hl.childhood.module.ShopingCar;
import com.hl.childhood.module.TgAddress;
import com.hl.childhood.service.SearchHisService;
import com.hl.childhood.service.TgAddressService;
import com.hl.childhood.vo.tgAddress.TgAddress1VO;
import com.hl.childhood.vo.tgAddress.TgAddressVO;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.common.util.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("tgAddressController")
@Scope("prototype")
public class TgAddressController extends BaseController {

    @Autowired
    private TgAddressService<TgAddress> tgAddressService;

    /**
     * 购物车 3. 默认收货地址接口
     * @return
     */
    @GetMapping(value = "/tg_addresss/default")
    public Result tgAddressDefault(HttpServletRequest request) {
        String loginer = getLoginerId(request);
        TgAddressVO vo = tgAddressService.getDefault(loginer);
        return Result.getSuccResult(vo);
    }

    /**
     * 购物车 4. 收货地址列表
     * @return
     */
    @GetMapping(value = "/tg_addresss")
    public Result tgAddresss(HttpServletRequest request) {
        List<TgAddress1VO> tgAddress1VOS = new ArrayList<>();
        String loginer = getLoginerId(request);
        tgAddress1VOS = tgAddressService.tgAddressList(loginer);
        return Result.getSuccResult(tgAddress1VOS);
    }

    /**
     * 购物车 5. 新增收货人地址接口
     * @return
     */
    @PostMapping(value = "/tg_addresss")
    public Result tgAddresssPost(HttpServletRequest request, @RequestBody HashMap<String, String> paramMap){
        try {
            if(StringUtils.isEmpty(paramMap.get("tg_name"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 tg_name");
            }
            if(StringUtils.isEmpty(paramMap.get("tg_phone"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 tg_phone");
            }
            if(StringUtils.isEmpty(paramMap.get("tg_ssq"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 tg_ssq");
            }
            if(StringUtils.isEmpty(paramMap.get("tg_address"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 tg_address");
            }
            TgAddress tgAddress = new TgAddress();
            tgAddress.setTga_id(UUIDGenerator.generate());
            tgAddress.setUser_id(getLoginerId(request));
            tgAddress.setTg_name(paramMap.get("tg_name"));
            tgAddress.setTg_phone(paramMap.get("tg_phone"));
            tgAddress.setTg_ssq(paramMap.get("tg_ssq"));
            tgAddress.setTg_address(paramMap.get("tg_address"));
            tgAddress.setIs_default(0);
            if(!StringUtils.isEmpty(paramMap.get("tg_num"))){
                tgAddress.setTg_num(paramMap.get("tg_num"));
            }
            tgAddressService.insert(tgAddress);

        }catch (Exception e){
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
        return Result.getSuccResult();
    }

    /**
     * 购物车 6. 修改收货人地址接口
     * @return
     */
    @PostMapping(value = "/tg_addresss/{tga_id}")
    public Result tgAddresssEdit(HttpServletRequest request, @RequestBody HashMap<String, String> paramMap,
                                 @PathVariable("tga_id") String tga_id){
        try {
            if(StringUtils.isEmpty(paramMap.get("tga_id"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 tga_id");
            }

            TgAddress tgAddress = new TgAddress();
            tgAddress.setTga_id(tga_id);
            if(!StringUtils.isEmpty(paramMap.get("tg_name"))){
                tgAddress.setTg_name(paramMap.get("tg_name"));
            }
            if(!StringUtils.isEmpty(paramMap.get("tg_phone"))){
                tgAddress.setTg_phone(paramMap.get("tg_phone"));
            }
            if(!StringUtils.isEmpty(paramMap.get("tg_ssq"))){
                tgAddress.setTg_ssq(paramMap.get("tg_ssq"));
            }
            if(!StringUtils.isEmpty(paramMap.get("tg_address"))){
                tgAddress.setTg_address(paramMap.get("tg_address"));
            }
            if(!StringUtils.isEmpty(paramMap.get("tg_num"))){
                tgAddress.setTg_num(paramMap.get("tg_num"));
            }
            tgAddressService.updateByPrimaryKey(tgAddress);

        }catch (Exception e){
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
        return Result.getSuccResult();
    }

    /**
     * 购物车 7. 收货地址详情接口
     * @return
     */
    @GetMapping(value = "/tg_address/{tga_id}")
    public Result tgAddressOne(HttpServletRequest request, @PathVariable("tga_id") String tga_id) {
        TgAddress tgAddress = new TgAddress();
        try {
            if(StringUtils.isEmpty(tga_id)){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 tga_id");
            }
            tgAddress = tgAddressService.selectByPrimaryKey(tga_id);
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return Result.getSuccResult(tgAddress);
    }

    /**
     * 购物车 8. 设置默认收货人地址接口
     * @return
     */
    @PostMapping(value = "/tg_addresss/default/{tga_id}")
    public Result tgAddresssEditDefault(HttpServletRequest request,
                                 @PathVariable("tga_id") String tga_id){
        try {
            if(StringUtils.isEmpty("tga_id")){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 tga_id");
            }

            tgAddressService.clearDefault(getLoginerId(request));
            tgAddressService.setDefault(tga_id);

        }catch (Exception e){
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
        return Result.getSuccResult();
    }


}

