package com.hl.childhood.vo.shopingCar;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车 2. 购物车商品推荐列表 VO
 * @author Administrator
 */
@Data
public class ShopingCarGoodsVO {
    private String goods_id;
    private String goods_image_link;
    private String goods_name;
    private String goods_desc;
    private BigDecimal goods_price;
}
