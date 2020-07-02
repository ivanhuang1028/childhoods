package com.hl.childhood.vo.order;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 购物车 10. 订单确认信息接口 VO
 * @author Administrator
 */
@Data
public class OrderCouponVO {
    private String uc_id;
    private String coupon_id;
    private String coupon_title;
    private String start_time;
    private String end_time;
    private Integer coupon_type;
    private Integer coupon_amount;
    private BigDecimal used_amount;
    private Integer is_selected;
}
