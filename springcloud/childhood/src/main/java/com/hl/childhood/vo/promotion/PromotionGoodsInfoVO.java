package com.hl.childhood.vo.promotion;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 首页 5. 首页--促销活动信息 VO
 * @author Administrator
 */
@Data
public class PromotionGoodsInfoVO {
    private String goods_id;
    private String goods_image_link;
    private String goods_name;
    private String goods_desc;
    private BigDecimal goods_price;
}
