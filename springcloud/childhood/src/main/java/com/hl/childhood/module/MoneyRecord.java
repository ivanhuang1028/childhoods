package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class MoneyRecord implements Serializable {

    //余额记录标识
    private String mr_id;

    //用户标识
    private String user_id;

    //1为分佣类型（加）、2为积分兑换余额类型（加）、3为消费兑换余额类型（减）、4为余额提现类型
    private Integer mr_type;

    //订单标识
    private String order_id;

    //分佣金额
    private BigDecimal commission;

    //积分记录标识
    private String cr_id;

    //积分兑换的余额数量
    private BigDecimal cr_num;

    //余额提现的数目
    private BigDecimal commit_money;

    //当前记录后的余额
    private BigDecimal current_money;

    //记录发生时间
    private Date create_time;

}