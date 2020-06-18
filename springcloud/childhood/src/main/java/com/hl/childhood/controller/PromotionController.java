package com.hl.childhood.controller;

import com.github.pagehelper.PageHelper;
import com.hl.childhood.module.Dictionary;
import com.hl.childhood.module.Promotion;
import com.hl.childhood.service.DictionaryService;
import com.hl.childhood.service.PromotionService;
import com.hl.childhood.util.Constants;
import com.hl.childhood.vo.dic.DicVO;
import com.hl.childhood.vo.goods.GoodsVO;
import com.hl.childhood.vo.page.PageVO;
import com.hl.childhood.vo.page.ResultsPageVO;
import com.hl.childhood.vo.promotion.*;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("promotionController")
@Scope("prototype")
public class PromotionController extends BaseController {

    @Autowired
    private PromotionService<Promotion> promotionService;

    /**
     * 首页 1. 首页轮播活动接口
     * @return
     */
    @GetMapping(value = "/homepages/lbt")
    public Result homepagesLbt(HttpServletRequest request) {
        List<PromotionLbtVO> promotionLbtVOS = new ArrayList<PromotionLbtVO>();
        String shopId = getLoginerShopId(request);
        promotionLbtVOS = promotionService.homepagesLbt(shopId);
        return Result.getSuccResult(promotionLbtVOS);
    }

    /**
     * 首页 3. 首页秒杀商品接口
     * @return
     */
    @GetMapping(value = "/goods/seckill")
    public Result promotionsSeckill(HttpServletRequest request) {
        List<PromotionSeckillVO> promotionSeckillVOS = new ArrayList<PromotionSeckillVO>();
        String shopId = getLoginerShopId(request);
        promotionSeckillVOS = promotionService.promotionsSeckill(shopId);
        return Result.getSuccResult(promotionSeckillVOS);
    }

    /**
     * 首页 5. 首页--促销活动信息
     * @return
     */
    @GetMapping(value = "/promotions/{promotion_id}")
    public Result promotionsOne(HttpServletRequest request, @PathVariable("promotion_id") String promotion_id) {
        PromotionInfoVO vo = promotionService.promotionsOne(promotion_id);
        return Result.getSuccResult(vo);
    }

    /**
     * 首页 6. 首页--促销活动下的商品列表接口
     * @return
     */
    @GetMapping(value = "/promotions/goods/{promotion_id}")
    public Result promotionsGoods(HttpServletRequest request, PageVO pageVO,
                                 @PathVariable("promotion_id") String promotion_id){
        List<PromotionGoodsInfoVO> promotionGoodsInfoVOs = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        promotionGoodsInfoVOs = promotionService.promotionsGoods(promotion_id);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(promotionGoodsInfoVOs, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 所有商品 5. 促销活动信息接口
     * @return
     */
    @GetMapping(value = "/promotions/{promotion_id}/{goods_id}")
    public Result promotions(HttpServletRequest request, @PathVariable("promotion_id") String promotion_id,
                         @PathVariable("goods_id") String goods_id){
        if(StringUtils.isEmpty(goods_id)){
            return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 goods_id");
        }
        if(StringUtils.isEmpty(promotion_id)){
            return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 promotion_id");
        }
        PromotionVO promotionVO = promotionService.promotionOne(promotion_id, goods_id);
        promotionVO.setCoupons(promotionService.getCoupons(promotionVO.getPromotion_id()));
        promotionVO.setSpes(promotionService.getSpes(promotion_id, goods_id));
        return Result.getSuccResult(promotionVO);
    }


}

