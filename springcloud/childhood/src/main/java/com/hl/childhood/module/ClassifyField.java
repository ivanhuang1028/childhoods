package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class ClassifyField implements Serializable {

    //分类字段标识
    private String cf_id;

    //商品分类标识
    private String classify_id;

    //字段名字
    private String cf_field;

    //序号
    private Integer cf_seq;


}