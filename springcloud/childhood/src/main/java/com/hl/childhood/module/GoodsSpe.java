package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class GoodsSpe implements Serializable {

    //商品规格标识
    private String spe_id;

    //所属商品标识
    private String goods_id;

    //规格名称
    private String spe_name;

    //此规格下的原价
    private BigDecimal spe_price;

    //此规格下的会员价格
    private BigDecimal member_price;

    //此规格图片地址
    private String spe_icon;

    //库存数量
    private Integer spe_inventory;

    //1为有效，0为无效
    private Integer is_valid;

    //排序
    private Integer spe_seq;

}