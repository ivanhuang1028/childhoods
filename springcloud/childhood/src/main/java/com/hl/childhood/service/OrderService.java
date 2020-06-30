package com.hl.childhood.service;

import com.hl.childhood.mapper.OrderMapper;
import com.hl.childhood.vo.order.OrderCouponVO;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface OrderService<T> extends BaseService<T>, OrderMapper<T> {

    List<OrderCouponVO> getOrderCoupon(String promotionId, BigDecimal price, String loginId);
}
