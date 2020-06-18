package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.MerchantMapper;
import com.hl.childhood.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("merchantService")
public class MerchantServiceImp<T> extends BaseServiceImp<T> implements MerchantService<T> {

    @Override
    public MerchantMapper<T> getMapper() {
        return (MerchantMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("merchantMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
