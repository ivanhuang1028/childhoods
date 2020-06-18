package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class Coupon implements Serializable {

    //优惠券标识
    private String coupon_id;

    //所属门店标识
    private String shop_id;

    //优惠券标题
    private String coupon_title;

    //优惠券图片地址
    private String coupon_icon;

    //用于：1为店铺优惠券、2为新人店铺券、3为商品优惠券、4为类目优惠券
    private Integer coupon_used;

    //1为满减卷（比如满300减100）、2为叠加满减卷、3为无门槛卷、4为满送卷（比如买3送1）
    private Integer coupon_type;

    //可用于特定商品标识
    private String goods_id;

    //可用于特点商品分类
    private String classify_id;

    //促销活动标识
    private String promotion_id;

    //满多少金额（个），如 无门槛卷，为0
    private Integer coupon_amount;

    //用卷金额是减多少金额（个）
    private BigDecimal used_amount;

    //用卷金额是打几折，只有小数点后1位
    private BigDecimal used_discount;

    //客户积分
    private Integer user_score;

    //配额：发券数量
    private Integer coupon_quota;

    //已领取的优惠券数量
    private Integer take_count;

    //已使用的优惠券数量
    private Integer used_count;

    //发放开始时间
    private Date start_time;

    //发放结束时间
    private Date end_time;

    //1为时效，绝对时效（领取后XXX-XXX时间段有效），2为相对时效（领取后N天有效）
    private Integer valid_type;

    //发放开始时间
    private Date valid_start_time;

    //使用结束时间
    private Date valid_end_time;

    //自领取之日起有效天数
    private Integer valid_days;

    //1生效 2失效 3已结束
    private Integer coupon_status;

    //
    private String create_user;

    //
    private Date create_time;

    //
    private String update_user;

    //
    private Date update_time;

}