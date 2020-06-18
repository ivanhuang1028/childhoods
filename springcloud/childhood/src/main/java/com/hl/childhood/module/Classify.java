package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class Classify implements Serializable {

    //分类标识
    private String classify_id;

    //门店标识
    private String shop_id;

    //分类名称
    private String classify_name;

    //分类小图地址
    private String classify_icon;

    //分类大图标识
    private String image_id;

    //此分类的资质认证文档地址
    private String merchant_qualification;

    //1为未审核，2为审核有效，0为无效
    private Integer is_valid;

}