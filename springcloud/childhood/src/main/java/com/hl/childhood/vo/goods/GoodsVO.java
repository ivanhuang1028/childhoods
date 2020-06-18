package com.hl.childhood.vo.goods;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 所有商品 2. 商品详情页【轮播图、基本信息和详情图片】接口 VO
 * @author Administrator
 */
@Data
public class GoodsVO {
    private String goods_id;
    private String classify_id;
    private String classify_name;
    private String brand_id;
    private String brand_name;
    private String goods_name;
    private String goods_desc;
    private BigDecimal goods_price;
    List<GoodsFieldVO> goods_fields;
    List<GoodsLbtVO> goods_lbt;
    List<GoodsXqtVO> goods_xqt;



}
