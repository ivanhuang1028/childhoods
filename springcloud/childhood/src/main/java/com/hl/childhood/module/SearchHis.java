package com.hl.childhood.module;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class SearchHis implements Serializable {

    //搜索历史标识
    private String sh_id;

    //用户标识
    private String user_id;

    //搜索历史值
    private String sh_value;

    //创建时间
    private String create_time;

}