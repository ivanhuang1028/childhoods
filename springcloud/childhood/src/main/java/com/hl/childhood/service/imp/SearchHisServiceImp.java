package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.SearchHisMapper;
import com.hl.childhood.service.SearchHisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("searchHisService")
public class SearchHisServiceImp<T> extends BaseServiceImp<T> implements SearchHisService<T> {

    @Override
    public SearchHisMapper<T> getMapper() {
        return (SearchHisMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("searchHisMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
