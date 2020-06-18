package com.hl.childhood.vo.classify;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 首页 4. 首页商品分类列表展示 VO
 * @author Administrator
 */
@Data
public class ClassifysGoodsVO {
    private String goods_id;
    private String goods_name;
    private String goods_desc;
    private String goods_image_link;
    private BigDecimal goods_price;
}
