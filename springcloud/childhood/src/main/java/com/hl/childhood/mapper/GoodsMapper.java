package com.hl.childhood.mapper;

import com.hl.childhood.vo.classify.ClassifysGoodsVO;
import com.hl.childhood.vo.goods.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface GoodsMapper<T> extends BaseMapper<T> {

    List<ClassifysGoodsVO> classifysGoods(@Param("classify_id") String classify_id, @Param("goods_num") Integer goods_num);

    List<GoodsInfoVO> goodsList(@Param("shopId") String shopId, @Param("key") String key, @Param("sort") Integer sort);

    GoodsVO goodsOne(@Param("goods_id") String goods_id);

    List<GoodsFieldVO> goodsFileds(@Param("goods_id") String goods_id);

    List<GoodsLbtVO> goodsLbt(@Param("goods_id") String goods_id);

    List<GoodsXqtVO> goodsXqt(@Param("goods_id") String goods_id);

}
