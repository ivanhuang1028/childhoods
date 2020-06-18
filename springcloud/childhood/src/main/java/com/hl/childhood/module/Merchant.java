package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ivan.huang
 */
@Data
public class Merchant implements Serializable {

    //商家标识
    private String merchant_id;

    //所属用户标识
    private String user_id;

    //商家详细联系地址
    private String merchant_address;

    //0为未审核，1为审核成功，2为审核失败
    private Integer merchant_status;

}