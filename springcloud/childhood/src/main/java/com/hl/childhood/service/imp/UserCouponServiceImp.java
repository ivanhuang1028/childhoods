package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.UserCouponMapper;
import com.hl.childhood.service.UserCouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("userCouponService")
public class UserCouponServiceImp<T> extends BaseServiceImp<T> implements UserCouponService<T> {

    @Override
    public UserCouponMapper<T> getMapper() {
        return (UserCouponMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("userCouponMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
