package com.hl.childhood.service;

import com.hl.childhood.mapper.TgAddressMapper;
import com.hl.childhood.vo.tgAddress.TgAddress1VO;
import com.hl.childhood.vo.tgAddress.TgAddressVO;

import java.util.List;

public interface TgAddressService<T> extends BaseService<T>, TgAddressMapper<T> {

    TgAddressVO getDefault(String loginer);

    List<TgAddress1VO> tgAddressList(String loginer);

    void clearDefault(String loginerId);

    void setDefault(String tga_id);
}
