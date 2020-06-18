package com.hl.childhood.mapper;

import com.hl.childhood.vo.classify.ClassifysGoodsInfoVO;
import com.hl.childhood.vo.classify.ClassifysGridVO;
import com.hl.childhood.vo.classify.ClassifysListVO;
import com.hl.childhood.vo.classify.ClassifysVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface ClassifyMapper<T> extends BaseMapper<T> {

    List<ClassifysGridVO> classifysGrid(@Param("shopId") String shopId);

    List<ClassifysListVO> classifysList(@Param("shopId") String shopId, @Param("classifys_num") Integer classifys_num);

    List<ClassifysGoodsInfoVO> classifysGoods(@Param("classify_id") String classify_id, @Param("sort") Integer sort);

    List<ClassifysVO> classifysInfo(@Param("shopId") String shopId);

}
