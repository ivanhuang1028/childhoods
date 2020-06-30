package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.ShopingCarMapper;
import com.hl.childhood.module.OrderGoods;
import com.hl.childhood.service.ShopingCarService;
import com.hl.childhood.vo.order.OrderGoodsVO;
import com.hl.childhood.vo.order.OrderGoodsVO1;
import com.hl.childhood.vo.shopingCar.ShopingCarGoodsVO;
import com.hl.childhood.vo.shopingCar.ShopingCarVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("shopingCarService")
public class ShopingCarServiceImp<T> extends BaseServiceImp<T> implements ShopingCarService<T> {

    @Override
    public ShopingCarMapper<T> getMapper() {
        return (ShopingCarMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("shopingCarMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public List<ShopingCarVO> shopingCarsList(String shopId, String loginerId) {
        return getMapper().shopingCarsList(shopId, loginerId);
    }

    @Override
    public List<ShopingCarGoodsVO> shopingCarsGoods(String shopId) {
        return getMapper().shopingCarsGoods(shopId);
    }

    @Override
    public List<OrderGoodsVO> orderGoods(List<String> scIds) {
        return getMapper().orderGoods(scIds);
    }

    @Override
    public List<OrderGoodsVO1> getOrderGoods(List<String> scIds) {
        return getMapper().getOrderGoods(scIds);
    }
}
