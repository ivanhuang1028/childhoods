package com.hl.childhood.vo.shopingCar;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 所有商品 1. 所有商品分类列表接口 VO
 * @author Administrator
 */
@Data
public class ShopingCarVO {
    private String goods_id;
    private String goods_name;
    private String spe_id;
    private String spe_name;
    private String spe_desc;
    private BigDecimal spe_price;
    private BigDecimal sc_price;
    private Integer sc_num;
}
