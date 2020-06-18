package com.hl.childhood.vo.promotion;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 所有商品 5. 促销活动信息接口 VO
 * @author Administrator
 */
@Data
public class SpecVO {
    private String spe_id;
    private String spe_name;
    private String spe_desc;
    private BigDecimal spe_promotion_price;
    private Integer spe_promotion_inventory;
    private String spe_icon;
}
