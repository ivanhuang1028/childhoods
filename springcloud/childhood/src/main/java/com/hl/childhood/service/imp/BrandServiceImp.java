package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.BrandMapper;
import com.hl.childhood.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("brandService")
public class BrandServiceImp<T> extends BaseServiceImp<T> implements BrandService<T> {

    @Override
    public BrandMapper<T> getMapper() {
        return (BrandMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("brandMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
