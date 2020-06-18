package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class Promotion implements Serializable {

    //促销活动标识
    private String promotion_id;

    //促销活动名称
    private String promotion_name;

    //店的标识
    private String shop_id;

    //促销活动图片地址
    private String image_id;

    //促销活动开始时间
    private Date start_time;

    //促销活动结束时间
    private Date end_time;

    //1为下架，2为上架，0为无效
    private Integer is_valid;

    //序号
    private Integer promotion_seq;

}