package com.hl.childhood.vo.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 购物车 12. 新增订单接口 VO
 * @author Administrator
 */
@Data
public class OrderGoodsVO1 {
    private String sc_id;
    private String goods_id;
    private String promotion_id;
    private String spe_id;
    private BigDecimal spe_price;
    private Integer spe_seq;
}
