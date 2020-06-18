package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.ClassifyMapper;
import com.hl.childhood.service.ClassifyService;
import com.hl.childhood.vo.classify.ClassifysGoodsInfoVO;
import com.hl.childhood.vo.classify.ClassifysGridVO;
import com.hl.childhood.vo.classify.ClassifysListVO;
import com.hl.childhood.vo.classify.ClassifysVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("classifyService")
public class ClassifyServiceImp<T> extends BaseServiceImp<T> implements ClassifyService<T> {

    @Override
    public ClassifyMapper<T> getMapper() {
        return (ClassifyMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("classifyMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public List<ClassifysGridVO> classifysGrid(String shopId) {
        return getMapper().classifysGrid(shopId);
    }

    @Override
    public List<ClassifysListVO> classifysList(String shopId, Integer classifys_num) {
        return getMapper().classifysList(shopId, classifys_num);
    }

    @Override
    public List<ClassifysGoodsInfoVO> classifysGoods(String classify_id, Integer sort) {
        return getMapper().classifysGoods(classify_id, sort);
    }

    @Override
    public List<ClassifysVO> classifysInfo(String shopId) {
        return getMapper().classifysInfo(shopId);
    }
}
