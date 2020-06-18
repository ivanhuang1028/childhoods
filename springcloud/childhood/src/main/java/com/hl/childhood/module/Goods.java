package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class Goods implements Serializable {

    //商品标识
    private String goods_id;

    //分类标识
    private String classify_id;

    //品牌标识
    private String brand_id;

    //商品名称
    private String goods_name;

    //商品原价
    private BigDecimal goods_price;

    //商品主图标识
    private String image_id;

    //商品关键字搜索
    private String goods_search;

    //1为下架，2为上架，0为无效
    private Integer goods_status;

    //上架时间
    private Date putaway_time;

    //新建时间
    private Date createtime;

}