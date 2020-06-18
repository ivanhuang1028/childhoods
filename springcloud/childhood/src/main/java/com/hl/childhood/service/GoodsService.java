package com.hl.childhood.service;

import com.hl.childhood.mapper.GoodsMapper;
import com.hl.childhood.vo.classify.ClassifysGoodsVO;
import com.hl.childhood.vo.goods.*;

import java.util.List;

public interface GoodsService<T> extends BaseService<T>, GoodsMapper<T> {

    List<ClassifysGoodsVO> classifysGoods(String classify_id, Integer goods_num);

    List<GoodsInfoVO> goodsList(String shopId, String key, Integer sort);

    GoodsVO goodsOne(String goods_id);

    List<GoodsFieldVO> goodsFileds(String goods_id);

    List<GoodsLbtVO> goodsLbt(String goods_id);

    List<GoodsXqtVO> goodsXqt(String goods_id);
}
