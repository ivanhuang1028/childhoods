package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.PromotionMapper;
import com.hl.childhood.service.PromotionService;
import com.hl.childhood.vo.promotion.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("promotionService")
public class PromotionServiceImp<T> extends BaseServiceImp<T> implements PromotionService<T> {

    @Override
    public PromotionMapper<T> getMapper() {
        return (PromotionMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("promotionMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public List<PromotionLbtVO> homepagesLbt(String shopId) {
        return getMapper().homepagesLbt(shopId);
    }

    @Override
    public List<PromotionSeckillVO> promotionsSeckill(String shopId) {
        return getMapper().promotionsSeckill(shopId);
    }

    @Override
    public PromotionInfoVO promotionsOne(String promotion_id) {
        return getMapper().promotionsOne(promotion_id);
    }

    @Override
    public List<PromotionGoodsInfoVO> promotionsGoods(String promotion_id) {
        return getMapper().promotionsGoods(promotion_id);
    }

    @Override
    public PromotionVO promotionOne(String promotion_id, String goods_id) {
        return getMapper().promotionOne(promotion_id, goods_id);
    }

    @Override
    public List<CouponVO> getCoupons(String promotion_id) {
        return getMapper().getCoupons(promotion_id);
    }

    @Override
    public List<SpecVO> getSpes(String promotion_id, String goods_id) {
        return getMapper().getSpes(promotion_id, goods_id);
    }
}
