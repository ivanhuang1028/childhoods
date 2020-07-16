package com.hl.childhood.vo.user;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 个人中心 4. 我的优惠券列表接口 VO
 */
@Data
public class UserCouponsVO {
    private String uc_id;
    private String coupon_id;
    private String coupon_title;
    private String start_time;
    private String end_time;
    private Integer coupon_type;
    private Integer coupon_amount;
    private BigDecimal used_amount;

}
