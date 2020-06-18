package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.GoodsValueMapper;
import com.hl.childhood.service.GoodsValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("goodsValueService")
public class GoodsValueServiceImp<T> extends BaseServiceImp<T> implements GoodsValueService<T> {

    @Override
    public GoodsValueMapper<T> getMapper() {
        return (GoodsValueMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("goodsValueMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
