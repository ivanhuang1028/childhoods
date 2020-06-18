package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class CoreRecord implements Serializable {

    //用户积分记录标识
    private String ur_id;

    //用户标识
    private String user_id;

    //1为消费类型（加）、2为直接推荐类型（加）、3为积分兑换余额类型（减）、4为积分兑换商品类型（减）
    private Integer record_type;

    //订单标识
    private String order_id;

    //被推荐人标识，是直接被用户推荐的客户标识
    private String recommend_id;

    //兑换余额记录标识
    private String mr_id;

    //兑换积分数量
    private Integer mr_score;

    //当前记录后的积分
    private Integer current_score;

    //记录发生时间
    private Date record_time;

}