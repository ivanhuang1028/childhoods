package com.hl.childhood.vo.user;

import lombok.Data;

/**
 * 个人中心 3. 登录人金额信息接口 VO
 */
@Data
public class UserMoneyRecordVO {
    private String mr_id;
    private Integer mr_type;
    private String order_id;
    private String order_code;
    private String order_username;
    private String order_total;
    private String commission;
    private String cr_id;
    private String cr_num;
    private String commit_money;
    private String create_time;
}
