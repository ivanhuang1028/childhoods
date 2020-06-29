package com.hl.childhood.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hl.childhood.module.Order;
import com.hl.childhood.module.Shop;
import com.hl.childhood.module.ShopingCar;
import com.hl.childhood.service.OrderService;
import com.hl.childhood.service.ShopService;
import com.hl.childhood.service.ShopingCarService;
import com.hl.childhood.util.StringUtil;
import com.hl.childhood.vo.order.OrderGoodsVO;
import com.hl.childhood.vo.order.OrderInfoVO;
import com.hl.childhood.vo.order.ShopOrderVO;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("orderController")
@Scope("prototype")
public class OrderController extends BaseController {

    @Autowired
    private OrderService<Order> orderService;

    @Autowired
    private ShopService<Shop> shopService;

    @Autowired
    private ShopingCarService<ShopingCar> shopingCarService;

    /**
     * 购物车 10. 订单确认信息接口
     * @return
     */
    @GetMapping(value = "/orders/draft/{shop_id}")
    public Result ordersDraft(HttpServletRequest request, String order_info, @PathVariable("shop_id") String shop_id){
        ShopOrderVO vo = new ShopOrderVO();
        try {
            if(StringUtils.isEmpty(order_info)){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 order_info");
            }
            if(StringUtils.isEmpty(shop_id)){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 shop_id");
            }
            List<OrderInfoVO> vos = JSON.parseObject(order_info, new TypeReference<ArrayList<OrderInfoVO>>(){});
            List<String> scIds = new ArrayList<>();
            for(OrderInfoVO orderInfoVO : vos){
                scIds.add(orderInfoVO.getSc_id());
            }

            Shop shop = shopService.selectByPrimaryKey(shop_id);
            vo.setShop_id(shop.getShop_id());
            vo.setShop_name(shop.getShop_name());

            List<OrderGoodsVO> order_goodss = shopingCarService.orderGoods(scIds);
            for(OrderGoodsVO orderGoodsVO : order_goodss){
                for(OrderInfoVO orderInfoVO : vos){
                    if(StringUtils.equals(orderInfoVO.getSc_id(), orderGoodsVO.getSc_id())){
                        orderGoodsVO.setSc_num(orderInfoVO.getSc_num());
                    }
                }
            }
            vo.setOrder_goodss(order_goodss);

            Map<String, BigDecimal> promotionPrice = new HashMap<String, BigDecimal>();
            for(OrderGoodsVO orderGoodsVO : order_goodss){
                String promotion_id = orderGoodsVO.getPromotion_id();
                BigDecimal price = orderGoodsVO.getSc_price().multiply(BigDecimal.valueOf(orderGoodsVO.getSc_num()));
                if(promotionPrice.containsKey(promotion_id)){
                    promotionPrice.put(promotion_id, price.add(promotionPrice.get(promotion_id)));
                }else{
                    promotionPrice.put(promotion_id, price);
                }
            }

//            vo.setOrder_coupons_can(orderService.getOrderCouponsCan(scIds, getLoginerId(request)));
//            vo.setOrder_coupons_canot(orderService.getOrderCouponsCanot(scIds, getLoginerId(request)));
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Result.getSuccResult(vo);
    }




}

