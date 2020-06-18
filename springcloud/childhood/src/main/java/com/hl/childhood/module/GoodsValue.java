package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ivan.huang
 */
@Data
public class GoodsValue implements Serializable {

    //商品字段值
    private String gv_id;

    //商品标识
    private String goods_id;

    //字段标识
    private String cf_id;

    //字段值
    private String gv_value;

}