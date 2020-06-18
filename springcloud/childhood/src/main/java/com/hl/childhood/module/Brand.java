package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class Brand implements Serializable {

    //品牌标识
    private String brand_id;

    //品牌名称
    private String brand_name;

    //品牌logo地址
    private String brand_logo;

    //本店标识
    private String shop_id;

    //1为有效，0为失效
    private Integer is_valid;

}