package com.hl.childhood.mapper;

import com.hl.childhood.vo.shopingCar.ShopingCarGoodsVO;
import com.hl.childhood.vo.shopingCar.ShopingCarVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface ShopingCarMapper<T> extends BaseMapper<T> {

    List<ShopingCarVO> shopingCarsList(@Param("shopId") String shopId, @Param("loginerId") String loginerId);

    List<ShopingCarGoodsVO> shopingCarsGoods(@Param("shopId") String shopId);

}
