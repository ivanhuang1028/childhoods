package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class OrderGoods implements Serializable {

    //订单的商品标识
    private String tog_id;

    //订单标识
    private String order_id;

    //活动标识
    private String promotion_id;

    //订单下商品标识
    private String goods_id;

    //订单下商品规格标识
    private String spe_id;

    //订单下此商品规格的数量
    private Integer spe_num;

    //订单下此商品规格的单价
    private BigDecimal spe_price;

    //同一订单下此商品规格的序号
    private Integer spe_seq;

}