package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.OrderCouponMapper;
import com.hl.childhood.service.OrderCouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("orderCouponService")
public class OrderCouponServiceImp<T> extends BaseServiceImp<T> implements OrderCouponService<T> {

    @Override
    public OrderCouponMapper<T> getMapper() {
        return (OrderCouponMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("orderCouponMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
