package com.hl.childhood.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hl.childhood.module.*;
import com.hl.childhood.service.*;
import com.hl.childhood.vo.order.*;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.common.util.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private OrderGoodsService<OrderGoods> orderGoodsService;

    @Autowired
    private OrderCouponService<OrderCoupon> orderCouponService;

    @Autowired
    private UserCouponService<UserCoupon> userCouponService;

    /**
     * 购物车 10. 订单确认信息接口
     * @return
     */
    @GetMapping(value = "/orders/draft/{shop_id}")
    public Result ordersDraft(HttpServletRequest request, @PathVariable("shop_id") String shop_id, @RequestBody OrderDraftVO orderDraftVO){
        ShopOrderVO vo = new ShopOrderVO();
        try {
            if(orderDraftVO == null || ArrayUtils.isEmpty(orderDraftVO.getOrder_info().toArray())){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 order_info");
            }
            if(StringUtils.isEmpty(shop_id)){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 shop_id");
            }
            List<OrderInfoVO> vos = orderDraftVO.getOrder_info();
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

            List<OrderCouponVO> order_coupons_can = new ArrayList<>();
            for(String promotionId : promotionPrice.keySet()){
                List<OrderCouponVO> vos1 = orderService.getOrderCoupon(promotionId, promotionPrice.get(promotionId), getLoginerId(request));
                if(!ArrayUtils.isEmpty(vos1.toArray())){
                    order_coupons_can.addAll(vos1);
                }
            }
            vo.setOrder_coupons_can(order_coupons_can);

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Result.getSuccResult(vo);
    }

    /**
     * 购物车 12. 新增订单接口
     * @return
     */
    @PostMapping(value = "/orders")
    public Result ordersPost(HttpServletRequest request, @RequestBody OrderPramaterVO orderPramaterVO){
        try {
            if(orderPramaterVO.getOrder_info() == null || ArrayUtils.isEmpty(orderPramaterVO.getOrder_info().toArray())){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 order_info");
            }
            if(StringUtils.isEmpty(orderPramaterVO.getDic_id())){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 dic_id");
            }
            if(StringUtils.isEmpty(orderPramaterVO.getOrder_total())){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 order_total");
            }

            //新增订单基础信息
            Order order = new Order();
            order.setOrder_id(UUIDGenerator.generate());
            order.setUser_id(getLoginerId(request));
            order.setOrder_total(new BigDecimal(orderPramaterVO.getOrder_total()));
            if(!StringUtils.isEmpty(orderPramaterVO.getOrder_freight())){
                order.setOrder_freight(new BigDecimal(orderPramaterVO.getOrder_freight()));
            }
            order.setOrder_type(1);
            order.setPay_type(1);
            order .setOrder_status(1);
            if(!StringUtils.isEmpty(orderPramaterVO.getOrder_msg())){
                order.setOrder_msg(orderPramaterVO.getOrder_msg());
            }
            order.setDis_type(orderPramaterVO.getDic_id());
            if(!StringUtils.isEmpty(orderPramaterVO.getTga_id())){
                order.setTga_id(orderPramaterVO.getTga_id());
            }
            orderService.insert(order);

            //新增订单商品信息
            List<OrderInfoVO> vos = orderPramaterVO.getOrder_info();
            List<String> scIds = new ArrayList<>();
            for(OrderInfoVO orderInfoVO : vos){
                scIds.add(orderInfoVO.getSc_id());
            }
            List<OrderGoodsVO1> orderGoodsList = shopingCarService.getOrderGoods(scIds);
            for(OrderGoodsVO1 orderGoods1 : orderGoodsList){
                OrderGoods orderGoods = new OrderGoods();
                orderGoods.setTog_id(UUIDGenerator.generate());
                orderGoods.setOrder_id(order.getOrder_id());
                orderGoods.setPromotion_id(orderGoods1.getPromotion_id());
                orderGoods.setGoods_id(orderGoods1.getGoods_id());
                orderGoods.setSpe_id(orderGoods1.getSpe_id());
                orderGoods.setSpe_price(orderGoods1.getSpe_price());
                orderGoods.setSpe_seq(orderGoods1.getSpe_seq());
                for(OrderInfoVO orderInfoVO : vos){
                    if(StringUtils.equals(orderInfoVO.getSc_id(), orderGoods1.getSc_id())){
                        orderGoods.setSpe_num(orderInfoVO.getSc_num());
                    }
                }
                orderGoodsService.insert(orderGoods);
            }

            //新增订单优惠券
            if(!StringUtils.isEmpty(orderPramaterVO.getUc_id())){
                OrderCoupon orderCoupon = new OrderCoupon();
                orderCoupon.setOc_id(UUIDGenerator.generate());
                orderCoupon.setOrder_id(order.getOrder_id());
                orderCoupon.setUc_id(orderPramaterVO.getUc_id());
                orderCouponService.insert(orderCoupon);

                UserCoupon uc = new UserCoupon();
                uc.setUc_id(orderPramaterVO.getUc_id());
                uc.setStatus(2);
                userCouponService.updateByPrimaryKey(uc);
            }

        }catch (Exception e){
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
        return Result.getSuccResult();
    }


}

