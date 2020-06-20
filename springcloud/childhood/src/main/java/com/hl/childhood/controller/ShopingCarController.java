package com.hl.childhood.controller;

import com.github.pagehelper.PageHelper;
import com.hl.childhood.module.SearchHis;
import com.hl.childhood.module.Shop;
import com.hl.childhood.module.ShopingCar;
import com.hl.childhood.service.ShopService;
import com.hl.childhood.service.ShopingCarService;
import com.hl.childhood.util.Constants;
import com.hl.childhood.vo.classify.ClassifysVO;
import com.hl.childhood.vo.page.PageVO;
import com.hl.childhood.vo.page.ResultsPageVO;
import com.hl.childhood.vo.promotion.PromotionGoodsInfoVO;
import com.hl.childhood.vo.shopingCar.ShopVO;
import com.hl.childhood.vo.shopingCar.ShopingCarGoodsVO;
import com.hl.childhood.vo.shopingCar.ShopingCarVO;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.common.util.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
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
@RestController("shopingCarController")
@Scope("prototype")
public class ShopingCarController extends BaseController {

    @Autowired
    private ShopingCarService<ShopingCar> shopingCarService;

    @Autowired
    private ShopService<Shop> shopService;

    /**
     * 所有商品 6. 加入购物车接口
     * 完成第二块
     * @return
     */
    @PostMapping(value = "/shoping_cars")
    public Result shopingCars(HttpServletRequest request, @RequestBody HashMap<String, String> paramMap){
        try {
            if(StringUtils.isEmpty(paramMap.get("spe_id"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 spe_id");
            }
            if(StringUtils.isEmpty(paramMap.get("sc_price"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 sc_price");
            }
            if(paramMap.get("sc_num") == null){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 sc_num");
            }
            ShopingCar shopingCar = new ShopingCar();
            shopingCar.setSc_id(UUIDGenerator.generate());
            shopingCar.setSpe_id(paramMap.get("spe_id"));
            shopingCar.setSc_price(BigDecimal.valueOf(Double.valueOf(paramMap.get("sc_price"))));
            shopingCar.setSc_num(Integer.valueOf(paramMap.get("sc_num")));
            if(!StringUtils.isEmpty(paramMap.get("promotion_id"))){
                shopingCar.setPromotion_id(paramMap.get("promotion_id"));
            }
            shopingCar.setUser_id(getLoginerId(request));
            shopingCarService.insert(shopingCar);

        }catch (Exception e){
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
        return Result.getSuccResult();
    }

    /**
     * 购物车 1. 购物车列表
     * @return
     */
    @GetMapping(value = "/shoping_cars")
    public Result shopingCarsList(HttpServletRequest request) {
        ShopVO shopVO = new ShopVO();
        try {
            String loginerId = getLoginerId(request);
            String shopId = getLoginerShopId(request);
            Shop shop = shopService.selectByPrimaryKey(shopId);
            shopVO.setShop_id(shop.getShop_id());
            shopVO.setShop_name(shop.getShop_name());
            List<ShopingCarVO> shop_cars = shopingCarService.shopingCarsList(shopId, loginerId);
            shopVO.setShop_cars(shop_cars);
            List<ShopingCarVO> platform_cars = shopingCarService.shopingCarsList(Constants.PLATFORM_SHOP_ID, loginerId);
            if(!ArrayUtils.isEmpty(platform_cars.toArray())){
                shopVO.setPlatform_cars(platform_cars);
                Shop platformShop = shopService.selectByPrimaryKey(Constants.PLATFORM_SHOP_ID);
                shopVO.setPlatform_shop_id(platformShop.getShop_id());
                shopVO.setPlatform_shop_name(platformShop.getShop_name());
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return Result.getSuccResult(shopVO);
    }

    /**
     * 购物车 2. 购物车商品推荐列表
     * @return
     */
    @GetMapping(value = "/shoping_car/goods")
    public Result shopingCarsGoods(HttpServletRequest request, PageVO pageVO){
        List<ShopingCarGoodsVO> shopingCarGoodsVOS = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        shopingCarGoodsVOS = shopingCarService.shopingCarsGoods(getLoginerShopId(request));
        ResultsPageVO resultsPageVO = ResultsPageVO.init(shopingCarGoodsVOS, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }



}

