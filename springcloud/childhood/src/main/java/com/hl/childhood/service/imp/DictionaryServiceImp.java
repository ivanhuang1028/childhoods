package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.DictionaryMapper;
import com.hl.childhood.module.Dictionary;
import com.hl.childhood.service.DictionaryService;
import com.hl.childhood.service.imp.BaseServiceImp;
import com.hl.childhood.vo.dic.DicVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("dictionaryService")
public class DictionaryServiceImp<T> extends BaseServiceImp<T> implements DictionaryService<T> {

    @Override
    public DictionaryMapper<T> getMapper() {
        return (DictionaryMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("dictionaryMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }

    @Override
    public List<DicVO> getMods() {
        return getMapper().getMods();
    }
}
