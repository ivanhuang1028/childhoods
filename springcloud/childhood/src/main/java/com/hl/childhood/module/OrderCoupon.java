package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ivan.huang
 */
@Data
public class OrderCoupon implements Serializable {

    //订单使用的优惠券标识
    private String oc_id;

    //订单标识
    private String order_id;

    //用户领优惠券标识
    private String uc_id;

}