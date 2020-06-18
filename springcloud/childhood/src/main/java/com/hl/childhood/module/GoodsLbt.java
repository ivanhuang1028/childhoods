package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ivan.huang
 */
@Data
public class GoodsLbt implements Serializable {

    //商品轮播图标识
    private String lbt_id;

    //商品标识
    private String goods_id;

    //图片标识
    private String image_id;

    //序
    private String lbt_seq;

}