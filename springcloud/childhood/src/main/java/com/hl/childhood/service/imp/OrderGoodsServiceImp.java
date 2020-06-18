package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.OrderGoodsMapper;
import com.hl.childhood.service.OrderGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("orderGoodsService")
public class OrderGoodsServiceImp<T> extends BaseServiceImp<T> implements OrderGoodsService<T> {

    @Override
    public OrderGoodsMapper<T> getMapper() {
        return (OrderGoodsMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("orderGoodsMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
