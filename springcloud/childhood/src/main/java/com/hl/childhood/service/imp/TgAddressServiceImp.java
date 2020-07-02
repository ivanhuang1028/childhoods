package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.TgAddressMapper;
import com.hl.childhood.service.TgAddressService;
import com.hl.childhood.vo.tgAddress.TgAddress1VO;
import com.hl.childhood.vo.tgAddress.TgAddressVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public TgAddressVO getDefault(String loginer) {
        return getMapper().getDefault(loginer);
    }

    @Override
    public List<TgAddress1VO> tgAddressList(String loginer) {
        return getMapper().tgAddressList(loginer);
    }

    @Override
    public void clearDefault(String loginerId) {
        getMapper().clearDefault(loginerId);
    }

    @Override
    public void setDefault(String tga_id) {
        getMapper().setDefault(tga_id);
    }
}
