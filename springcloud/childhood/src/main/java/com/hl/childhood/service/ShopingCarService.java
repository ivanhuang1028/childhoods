package com.hl.childhood.service;

import com.hl.childhood.mapper.ShopingCarMapper;
import com.hl.childhood.vo.order.OrderGoodsVO;
import com.hl.childhood.vo.shopingCar.ShopingCarGoodsVO;
import com.hl.childhood.vo.shopingCar.ShopingCarVO;

import java.util.List;

public interface ShopingCarService<T> extends BaseService<T>, ShopingCarMapper<T> {

    List<ShopingCarVO> shopingCarsList(String shopId, String loginerId);

    List<ShopingCarGoodsVO> shopingCarsGoods(String shopId);

    List<OrderGoodsVO> orderGoods(List<String> scIds);
}
