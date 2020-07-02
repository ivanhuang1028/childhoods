package com.hl.childhood.vo.order;

import lombok.Data;

import java.util.List;

/**
 * 购物车 12. 新增订单接口 VO
 * @author Administrator
 */
@Data
public class OrderPramaterVO {
    private List<OrderInfoVO> order_info;
    private String uc_id;
    private String dic_id;
    private String tga_id;
    private String order_freight;
    private String order_total;
    private String order_msg;
}
