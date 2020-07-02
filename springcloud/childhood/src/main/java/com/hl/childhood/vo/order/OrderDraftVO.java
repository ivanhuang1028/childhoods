package com.hl.childhood.vo.order;

import lombok.Data;

import java.util.List;

/**
 * 购物车 10. 订单确认信息接口 VO
 * @author Administrator
 */
@Data
public class OrderDraftVO {
    private List<OrderInfoVO> order_info;
}
