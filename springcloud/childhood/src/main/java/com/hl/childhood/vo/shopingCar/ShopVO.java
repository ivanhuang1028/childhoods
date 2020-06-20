package com.hl.childhood.vo.shopingCar;

import lombok.Data;

import java.util.List;

/**
 * 购物车 1. 购物车列表 VO
 * @author Administrator
 */
@Data
public class ShopVO {
    private String shop_id;
    private String shop_name;
    private List<ShopingCarVO> shop_cars;
    private String platform_shop_id;
    private String platform_shop_name;
    private List<ShopingCarVO> platform_cars;
}
