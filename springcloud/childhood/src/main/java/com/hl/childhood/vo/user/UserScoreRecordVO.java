package com.hl.childhood.vo.user;

import lombok.Data;

/**
 * 个人中心 6. 我的积分记录列表接口 VO
 */
@Data
public class UserScoreRecordVO {
    private String ur_id;
    private Integer record_type;
    private String order_id;
    private String order_code;
    private String order_username;
    private String order_total;
    private String recommend_id;
    private String recommend_name;
    private String mr_id;
    private Integer mr_score;
    private Integer score;
    private String record_time;
}
