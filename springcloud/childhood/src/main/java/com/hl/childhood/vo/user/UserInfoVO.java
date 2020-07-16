package com.hl.childhood.vo.user;

import lombok.Data;

/**
 * 个人中心 1. 登录人信息接口 VO
 */
@Data
public class UserInfoVO {
    private String user_id;
    private String user_icon;
    private String user_name;
    private String user_phone;
    private Integer user_sex;
    private String user_birthday;
    private String user_region;
    private String user_weixin_account;
    private String tg_address;
}
