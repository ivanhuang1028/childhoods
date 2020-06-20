package com.hl.childhood.mapper;

import com.hl.childhood.vo.tgAddress.TgAddress1VO;
import com.hl.childhood.vo.tgAddress.TgAddressVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface TgAddressMapper<T> extends BaseMapper<T> {

    TgAddressVO getDefault(@Param("loginer") String loginer);

    List<TgAddress1VO> tgAddressList(@Param("loginer") String loginer);

    void clearDefault(@Param("loginer") String loginerId);

    void setDefault(@Param("tga_id") String tga_id);

}
