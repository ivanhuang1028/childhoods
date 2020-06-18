package com.hl.childhood.module;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class ShopingCar implements Serializable {

    //购物车标识
    private String sc_id;

    //客户标识
    private String user_id;

    //商品促销活动标识
    private String promotion_id;

    //商品规格标识（客户标识与商品规格标识唯一）
    private String spe_id;

    //单价
    private BigDecimal sc_price;

    //数量
    private Integer sc_num;

    //加入购物车时间
    private Date createtime;

}