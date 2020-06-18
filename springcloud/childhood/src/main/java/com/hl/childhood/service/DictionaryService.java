package com.hl.childhood.service;

import com.hl.childhood.mapper.DictionaryMapper;
import com.hl.childhood.vo.dic.DicVO;

import java.util.List;

public interface DictionaryService<T> extends BaseService<T>, DictionaryMapper<T> {

    List<DicVO> queryByName(String dic_name);

    List<DicVO> queryUserLabels(String user_id);
}
