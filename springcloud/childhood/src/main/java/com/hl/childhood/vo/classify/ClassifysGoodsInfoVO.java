package com.hl.childhood.vo.classify;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 首页 7. 首页--商品分类的商品列表页面 VO
 * @author Administrator
 */
@Data
public class ClassifysGoodsInfoVO {
    private String goods_id;
    private String goods_image_link;
    private String goods_name;
    private String goods_desc;
    private BigDecimal goods_price;
}
