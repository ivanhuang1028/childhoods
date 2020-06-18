package com.hl.childhood.vo.promotion;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 首页 3. 首页秒杀活动展示 VO
 * @author Administrator
 */
@Data
public class PromotionSeckillVO {
    private String promotion_id;
    private String image_remote_link;
    private String start_time;
    private String end_time;
    private String goods_id;
    private String goods_name;
    private String goods_desc;
    private Integer promotion_used;
    private BigDecimal goods_price;
    private BigDecimal promotion_price;
    private Integer seq;
}
