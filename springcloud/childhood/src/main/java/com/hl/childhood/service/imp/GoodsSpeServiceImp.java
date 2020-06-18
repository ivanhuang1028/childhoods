package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.GoodsSpeMapper;
import com.hl.childhood.service.GoodsSpeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("goodsSpeService")
public class GoodsSpeServiceImp<T> extends BaseServiceImp<T> implements GoodsSpeService<T> {

    @Override
    public GoodsSpeMapper<T> getMapper() {
        return (GoodsSpeMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("goodsSpeMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
