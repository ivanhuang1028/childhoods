package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.GoodsMapper;
import com.hl.childhood.service.GoodsService;
import com.hl.childhood.vo.classify.ClassifysGoodsVO;
import com.hl.childhood.vo.goods.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("goodsService")
public class GoodsServiceImp<T> extends BaseServiceImp<T> implements GoodsService<T> {

    @Override
    public GoodsMapper<T> getMapper() {
        return (GoodsMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("goodsMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public List<ClassifysGoodsVO> classifysGoods(String classify_id, Integer goods_num) {
        return getMapper().classifysGoods(classify_id, goods_num);
    }

    @Override
    public List<GoodsInfoVO> goodsList(String shopId, String key, Integer sort) {
        return getMapper().goodsList(shopId, key,sort);
    }

    @Override
    public GoodsVO goodsOne(String goods_id) {
        return getMapper().goodsOne(goods_id);
    }

    @Override
    public List<GoodsFieldVO> goodsFileds(String goods_id) {
        return getMapper().goodsFileds(goods_id);
    }

    @Override
    public List<GoodsLbtVO> goodsLbt(String goods_id) {
        return getMapper().goodsLbt(goods_id);
    }

    @Override
    public List<GoodsXqtVO> goodsXqt(String goods_id) {
        return getMapper().goodsXqt(goods_id);
    }
}
