package com.hl.childhood.vo.user;

import lombok.Data;

/**
 * 个人中心 7. 我的订单列表接口 VO
 */
@Data
public class UserOrdersVO {
    private String shop_id;
    private String shop_name;
    private String order_id;
    private String order_code;
    private Integer order_status;
    private String order_total;
    private String goods_id;
    private String goods_name;
    private String spe_id;
    private String spe_name;
    private Integer spe_num;
    private Integer goods_num;
}
