package com.hl.childhood.vo.order;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 购物车 10. 订单确认信息接口 VO
 * @author Administrator
 */
@Data
public class OrderGoodsVO {
    private String sc_id;
    private String spe_icon;
    private String spe_name;
    private String spe_desc;
    private BigDecimal spe_price;
    private BigDecimal sc_price;
    private String promotion_id;
    private Integer sc_num;
}
