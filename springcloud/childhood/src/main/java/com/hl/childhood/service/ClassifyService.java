package com.hl.childhood.service;

import com.hl.childhood.mapper.ClassifyMapper;
import com.hl.childhood.vo.classify.ClassifysGoodsInfoVO;
import com.hl.childhood.vo.classify.ClassifysGridVO;
import com.hl.childhood.vo.classify.ClassifysListVO;
import com.hl.childhood.vo.classify.ClassifysVO;

import java.util.List;

public interface ClassifyService<T> extends BaseService<T>, ClassifyMapper<T> {

    List<ClassifysGridVO> classifysGrid(String shopId);

    List<ClassifysListVO> classifysList(String shopId, Integer classifys_num);

    List<ClassifysGoodsInfoVO> classifysGoods(String classify_id, Integer sort);

    List<ClassifysVO> classifysInfo(String shopId);
}
