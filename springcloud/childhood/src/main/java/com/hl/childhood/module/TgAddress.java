package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class TgAddress implements Serializable {

    //收货地址
    private String tga_id;

    //客户标识
    private String user_id;

    //收货人姓名
    private String tg_name;

    //收货人电话号码
    private String tg_phone;

    //所在省市区
    private String tg_ssq;

    //收货详细地址
    private String tg_address;

    //门牌号
    private String tg_num;

    //1为默认，0为非默认
    private Integer is_default;

    //创建时间
    private Date createtime;

}