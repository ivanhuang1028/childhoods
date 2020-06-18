package com.hl.childhood.vo.promotion;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 所有商品 5. 促销活动信息接口 VO
 * @author Administrator
 */
@Data
public class CouponVO {
    private String coupon_id;
    private String coupon_title;
    private Integer coupon_type;
    private Integer coupon_amount;
    private BigDecimal used_amount;
    private BigDecimal used_discount;
    private String valid_start_time;
    private String valid_end_time;
    private Integer valid_days;
}
