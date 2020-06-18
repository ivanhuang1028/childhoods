package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.CouponMapper;
import com.hl.childhood.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("couponService")
public class CouponServiceImp<T> extends BaseServiceImp<T> implements CouponService<T> {

    @Override
    public CouponMapper<T> getMapper() {
        return (CouponMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("couponMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
