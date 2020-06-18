package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.ShopingCarMapper;
import com.hl.childhood.service.ShopingCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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


}
