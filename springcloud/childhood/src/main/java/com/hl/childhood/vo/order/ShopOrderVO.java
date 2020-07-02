package com.hl.childhood.vo.order;

import com.hl.childhood.vo.shopingCar.ShopingCarVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车 10. 订单确认信息接口 VO
 * @author Administrator
 */
@Data
public class ShopOrderVO {
    private String shop_id;
    private String shop_name;
    private List<OrderGoodsVO> order_goodss;
    private List<OrderCouponVO> order_coupons_can;
}
