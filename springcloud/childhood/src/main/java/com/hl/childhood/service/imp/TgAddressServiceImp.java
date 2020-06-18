package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.TgAddressMapper;
import com.hl.childhood.service.TgAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("tgAddressService")
public class TgAddressServiceImp<T> extends BaseServiceImp<T> implements TgAddressService<T> {

    @Override
    public TgAddressMapper<T> getMapper() {
        return (TgAddressMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("tgAddressMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
