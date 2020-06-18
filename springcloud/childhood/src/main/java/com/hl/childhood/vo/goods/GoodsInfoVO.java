package com.hl.childhood.vo.goods;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 首页 10. 搜索列表接口 VO
 * @author Administrator
 */
@Data
public class GoodsInfoVO {
    private String goods_id;
    private String goods_image_link;
    private String goods_name;
    private String goods_desc;
    private BigDecimal goods_price;
}
