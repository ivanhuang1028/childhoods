package com.hl.childhood.service;

import com.hl.childhood.mapper.PromotionMapper;
import com.hl.childhood.vo.promotion.*;

import java.util.List;

public interface PromotionService<T> extends BaseService<T>, PromotionMapper<T> {

    List<PromotionLbtVO> homepagesLbt(String shopId);

    List<PromotionSeckillVO> promotionsSeckill(String shopId);

    PromotionInfoVO promotionsOne(String promotion_id);

    List<PromotionGoodsInfoVO> promotionsGoods(String promotion_id);

    PromotionVO promotionOne(String promotion_id, String goods_id);

    List<CouponVO> getCoupons(String promotion_id);

    List<SpecVO> getSpes(String promotion_id, String goods_id);
}
