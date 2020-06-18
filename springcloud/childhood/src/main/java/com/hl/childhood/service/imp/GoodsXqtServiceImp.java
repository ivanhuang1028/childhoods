package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.GoodsXqtMapper;
import com.hl.childhood.service.GoodsXqtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("goodsXqtService")
public class GoodsXqtServiceImp<T> extends BaseServiceImp<T> implements GoodsXqtService<T> {

    @Override
    public GoodsXqtMapper<T> getMapper() {
        return (GoodsXqtMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("goodsXqtMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
