package com.hl.childhood.mapper;

import com.hl.childhood.vo.promotion.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface PromotionMapper<T> extends BaseMapper<T> {

    List<PromotionLbtVO> homepagesLbt(@Param("shopId")String shopId);

    List<PromotionSeckillVO> promotionsSeckill(@Param("shopId") String shopId);

    PromotionInfoVO promotionsOne(@Param("promotion_id") String promotion_id);

    List<PromotionGoodsInfoVO> promotionsGoods(@Param("promotion_id") String promotion_id);

    PromotionVO promotionOne(@Param("promotion_id") String promotion_id, @Param("goods_id") String goods_id);

    List<CouponVO> getCoupons(@Param("promotion_id") String promotion_id);

    List<SpecVO> getSpes(@Param("promotion_id") String promotion_id, @Param("goods_id") String goods_id);

}
