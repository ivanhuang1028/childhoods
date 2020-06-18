package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.ClassifyFieldMapper;
import com.hl.childhood.service.ClassifyFieldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("classifyFieldService")
public class ClassifyFieldServiceImp<T> extends BaseServiceImp<T> implements ClassifyFieldService<T> {

    @Override
    public ClassifyFieldMapper<T> getMapper() {
        return (ClassifyFieldMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("classifyFieldMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
