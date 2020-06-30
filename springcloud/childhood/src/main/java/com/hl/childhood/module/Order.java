package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class Order implements Serializable {

    //订单标识
    private String order_id;

    //下订单的客户标识
    private String user_id;

    //创建时间
    private Date create_time;

    //订单结束时间
    private Date end_time;

    //订单总价
    private BigDecimal order_total;

    //订单总运费
    private BigDecimal order_freight;

    //1为购买订单，2为成为合伙人订单，3为积分兑换订单
    private Integer order_type;

    //1为第三方支付，2为余额支付，3为积分支付
    private Integer pay_type;

    //1为待付款，2为待发货，3为待收货，4为待评价，5为已评价，0为已取消
    private Integer order_status;

    //给商家的留言
    private String order_msg;

    //1为上门自取，2为免费送货到家，3为第三方快递，字典管理
    private String dis_type;

    //收款地址标识
    private String tga_id;

}