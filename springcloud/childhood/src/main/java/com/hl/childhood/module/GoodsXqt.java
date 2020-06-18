package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ivan.huang
 */
@Data
public class GoodsXqt implements Serializable {

    //商品详情图标识
    private String xqt_id;

    //商品标识
    private String goods_id;

    //详情图标识
    private String image_id;

    //序
    private String xqt_seq;

}