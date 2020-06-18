package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.MoneyRecordMapper;
import com.hl.childhood.service.MoneyRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("moneyRecordService")
public class MoneyRecordServiceImp<T> extends BaseServiceImp<T> implements MoneyRecordService<T> {

    @Override
    public MoneyRecordMapper<T> getMapper() {
        return (MoneyRecordMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("moneyRecordMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
