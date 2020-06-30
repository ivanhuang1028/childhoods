package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ivan.huang
 */
@Data
public class UserCoupon implements Serializable {

    //用户已领的优惠券记录标识
    private String uc_id;

    //用户标识
    private String user_id;

    //优惠券标识
    private String coupon_id;

    //领取时间
    private String create_time;

    //1为有效、2为已用、3为过期
    private Integer status;

}