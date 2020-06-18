package com.hl.childhood.vo.comment;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 所有商品 3. 商品评价类型及统计接口 VO
 * @author Administrator
 */
@Data
public class CommentTypeVO {
    private String comment_type_id;
    private String comment_type_name;
    private Integer comment_type_num;
}
