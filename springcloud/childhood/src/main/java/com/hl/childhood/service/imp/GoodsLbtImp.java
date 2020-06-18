package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.GoodsLbtMapper;
import com.hl.childhood.service.GoodsLbtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("goodsLbtService")
public class GoodsLbtImp<T> extends BaseServiceImp<T> implements GoodsLbtService<T> {

    @Override
    public GoodsLbtMapper<T> getMapper() {
        return (GoodsLbtMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("goodsLbtMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
