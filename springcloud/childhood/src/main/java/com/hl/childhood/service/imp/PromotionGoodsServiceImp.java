package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.PromotionGoodsMapper;
import com.hl.childhood.service.PromotionGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("promotionGoodsService")
public class PromotionGoodsServiceImp<T> extends BaseServiceImp<T> implements PromotionGoodsService<T> {

    @Override
    public PromotionGoodsMapper<T> getMapper() {
        return (PromotionGoodsMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("promotionGoodsMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
