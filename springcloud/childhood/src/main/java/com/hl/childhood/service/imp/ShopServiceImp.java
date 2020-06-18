package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.ShopMapper;
import com.hl.childhood.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("shopService")
public class ShopServiceImp<T> extends BaseServiceImp<T> implements ShopService<T> {

    @Override
    public ShopMapper<T> getMapper() {
        return (ShopMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("shopMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
