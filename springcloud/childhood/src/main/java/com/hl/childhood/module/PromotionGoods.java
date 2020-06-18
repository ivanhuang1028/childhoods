package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class PromotionGoods implements Serializable {

    //促销活动商品标识
    private String pg_id;

    //促销活动标识
    private String promotion_id;

    //商品规格标识
    private String spe_id;

    //促销价格
    private BigDecimal promotion_price;

    //促销库存
    private Integer promotion_inventory;

    //序号
    private Integer pg_seq;

}