package com.hl.childhood.vo.goods;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 所有商品 2. 商品详情页【轮播图、基本信息和详情图片】接口 VO
 * @author Administrator
 */
@Data
public class GoodsFieldVO {
    private String field_id;
    private String field_name;
    private String value;
}
