package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.CoreRecordMapper;
import com.hl.childhood.service.CoreRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("coreRecordService")
public class CoreRecordServiceImp<T> extends BaseServiceImp<T> implements CoreRecordService<T> {

    @Override
    public CoreRecordMapper<T> getMapper() {
        return (CoreRecordMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("coreRecordMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
