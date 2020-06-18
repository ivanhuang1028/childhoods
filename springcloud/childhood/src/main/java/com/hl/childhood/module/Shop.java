package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class Shop implements Serializable {

    //门店标识
    private String shop_id;

    //商家标识，当为0时，此门店属于平台体验区
    private String merchant_id;

    //门店名称
    private String shop_name;

    //门店所在的省
    private String shop_province;

    //门店所在的市
    private String shop_city;

    //门店所在的区
    private String shop_region;

    //门店的具体地址
    private String shop_address;

    //1为正常营业，0为关闭
    private Integer shop_status;

}