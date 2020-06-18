package com.hl.childhood.vo.promotion;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 所有商品 5. 促销活动信息接口 VO
 * @author Administrator
 */
@Data
public class PromotionVO {
    private String promotion_id;
    private String promotion_name;
    private String start_time;
    private String end_time;
    private String image_id;
    private String image_remote_link;
    private String goods_id;
    private String goods_name;
    private BigDecimal promotion_price;
    List<CouponVO> coupons;
    List<SpecVO> spes;
}
