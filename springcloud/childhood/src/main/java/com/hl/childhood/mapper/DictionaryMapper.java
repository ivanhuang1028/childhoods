package com.hl.childhood.mapper;

import com.hl.childhood.module.Dictionary;
import com.hl.childhood.vo.dic.DicVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface DictionaryMapper<T> extends BaseMapper<T> {

    List<DicVO> queryByName(@Param("dic_name") String dic_name);

    List<DicVO> queryUserLabels(@Param("user_id") String user_id);

}
