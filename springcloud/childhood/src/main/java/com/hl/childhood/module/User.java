package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class User implements Serializable {

    //用户标识
    private String user_id;

    //姓名
    private String user_name;

    //头像地址
    private String user_icon;

    //手机号
    private String user_phone;

    //1为男，2为女
    private Integer user_sex;

    //生日
    private String user_birthday;

    //地区
    private String user_region;

    //微信号
    private String user_weixin_account;

    //微信标识
    private String user_weixin_openid;

    //1为正常，0为失效
    private Integer user_status;

    //1为普通客户，2为商家，3为合伙人，4为黄金会员，5为白金会员，6为黑金会员，7为钻石会员
    private Integer user_role;

    //客户余额
    private BigDecimal user_money;

    //客户积分
    private Integer user_score;

    //如是普通客户，则所属的门店标识，注册时指定
    private String shop_id;

    //客户的直接推荐人标识
    private String user_pid;

    //客户的所有上层推荐人标识，多个，用逗号隔开
    private String user_pids;

    //用户最新操作时间
    private Date update_latest_time;

}