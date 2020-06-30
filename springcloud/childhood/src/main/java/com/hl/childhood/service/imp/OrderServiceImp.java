package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.OrderMapper;
import com.hl.childhood.service.OrderService;
import com.hl.childhood.vo.order.OrderCouponVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("orderService")
public class OrderServiceImp<T> extends BaseServiceImp<T> implements OrderService<T> {

    @Override
    public OrderMapper<T> getMapper() {
        return (OrderMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("orderMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public List<OrderCouponVO> getOrderCoupon(String promotionId, BigDecimal price, String loginId) {
        return getMapper().getOrderCoupon(promotionId, price, loginId);
    }
}
