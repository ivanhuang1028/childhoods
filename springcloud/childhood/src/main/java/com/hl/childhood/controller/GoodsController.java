package com.hl.childhood.controller;

import com.github.pagehelper.PageHelper;
import com.hl.childhood.module.Classify;
import com.hl.childhood.module.Goods;
import com.hl.childhood.service.ClassifyService;
import com.hl.childhood.service.GoodsService;
import com.hl.childhood.vo.classify.ClassifysGoodsInfoVO;
import com.hl.childhood.vo.classify.ClassifysGridVO;
import com.hl.childhood.vo.classify.ClassifysListVO;
import com.hl.childhood.vo.goods.GoodsInfoVO;
import com.hl.childhood.vo.goods.GoodsVO;
import com.hl.childhood.vo.page.PageVO;
import com.hl.childhood.vo.page.ResultsPageVO;
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
@RestController("goodsController")
@Scope("prototype")
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService<Goods> goodsService;

    /**
     * 首页 10. 搜索列表接口
     * sort: 1为综合排序，2为价格顺序，3为价格倒序，4为商品录入时间倒序，即“上新”
     * @return
     */
    @GetMapping(value = "/goods")
    public Result goodsList(HttpServletRequest request, PageVO pageVO,
                                 String key, Integer sort){
        if(sort == null || sort > 4){
            sort = 1;
        }
        List<GoodsInfoVO> goodsInfoVOS = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        goodsInfoVOS = goodsService.goodsList(getLoginerShopId(request), key, sort);
        ResultsPageVO resultsPageVO = ResultsPageVO.init(goodsInfoVOS, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }

    /**
     * 所有商品 2. 商品详情页【轮播图、基本信息和详情图片】接口
     * @return
     */
    @GetMapping(value = "/goodss/{goods_id}")
    public Result goodss(HttpServletRequest request, @PathVariable("goods_id") String goods_id){
        if(StringUtils.isEmpty(goods_id)){
            return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 goods_id");
        }
        GoodsVO goodsVO = goodsService.goodsOne(goods_id);
        goodsVO.setGoods_fields(goodsService.goodsFileds(goods_id));
        goodsVO.setGoods_lbt(goodsService.goodsLbt(goods_id));
        goodsVO.setGoods_xqt(goodsService.goodsXqt(goods_id));
        return Result.getSuccResult(goodsVO);
    }


}

