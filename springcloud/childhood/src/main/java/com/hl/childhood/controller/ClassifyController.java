package com.hl.childhood.controller;

import com.github.pagehelper.PageHelper;
import com.hl.childhood.module.Classify;
import com.hl.childhood.module.Goods;
import com.hl.childhood.module.Promotion;
import com.hl.childhood.service.ClassifyService;
import com.hl.childhood.service.GoodsService;
import com.hl.childhood.service.PromotionService;
import com.hl.childhood.vo.classify.*;
import com.hl.childhood.vo.page.PageVO;
import com.hl.childhood.vo.page.ResultsPageVO;
import com.hl.childhood.vo.promotion.PromotionGoodsInfoVO;
import com.hl.childhood.vo.promotion.PromotionLbtVO;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("classifyController")
@Scope("prototype")
public class ClassifyController extends BaseController {

    @Autowired
    private ClassifyService<Classify> classifyService;

    @Autowired
    private GoodsService<Goods> goodsService;

    /**
     * 首页 2. 首页商品分类小格子展示
     * @return
     */
    @GetMapping(value = "/classifys/grid")
    public Result classifysGrid(HttpServletRequest request) {
        List<ClassifysGridVO> classifysGridVO = new ArrayList<ClassifysGridVO>();
        String shopId = getLoginerShopId(request);
        classifysGridVO = classifyService.classifysGrid(shopId);
        return Result.getSuccResult(classifysGridVO);
    }

    /**
     * 首页 4. 首页商品分类列表展示
     * @return
     */
    @GetMapping(value = "/classifys/list")
    public Result classifysList(HttpServletRequest request, Integer classifys_num, Integer goods_num ) {
        if(classifys_num == null || classifys_num == 0){
            classifys_num = 6;
        }
        if(goods_num == null || goods_num == 0){
            goods_num = 6;
        }
        List<ClassifysListVO> classifysListVOs = new ArrayList<ClassifysListVO>();
        String shopId = getLoginerShopId(request);
        classifysListVOs = classifyService.classifysList(shopId, classifys_num);
        for(ClassifysListVO vo : classifysListVOs){
            vo.setGoodslist(goodsService.classifysGoods(vo.getClassify_id(), goods_num));
        }
        return Result.getSuccResult(classifysListVOs);
    }

    /**
     * 首页 7. 首页--商品分类的商品列表页面
     * sort: 1为综合排序，2为价格顺序，3为价格倒序，4为商品录入时间倒序，即“上新”
     * @return
     */
    @GetMapping(value = "/classifys/goods/{classify_id}")
    public Result classifysGoods(HttpServletRequest request, PageVO pageVO,
                                  @PathVariable("classify_id") String classify_id, Integer sort){
        if(StringUtils.isEmpty(classify_id)){
            return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 classify_id");
        }
        if(sort == null || sort > 4){
            sort = 1;
        }
        List<ClassifysGoodsInfoVO> classifysGoodsInfoVOS = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        classifysGoodsInfoVOS = classifyService.classifysGoods(classify_id, sort);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(classifysGoodsInfoVOS, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 所有商品 1. 所有商品分类列表接口
     * @return
     */
    @GetMapping(value = "/classifys")
    public Result classifys(HttpServletRequest request) {
        List<ClassifysVO> classifysVOS = new ArrayList<ClassifysVO>();
        String shopId = getLoginerShopId(request);
        classifysVOS = classifyService.classifysInfo(shopId);
        return Result.getSuccResult(classifysVOS);
    }


}

