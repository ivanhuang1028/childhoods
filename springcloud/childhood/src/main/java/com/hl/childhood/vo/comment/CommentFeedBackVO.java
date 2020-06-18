package com.hl.childhood.vo.comment;

import lombok.Data;

/**
 * 所有商品 4. 商品评价列表接口 VO
 * @author Administrator
 */
@Data
public class CommentFeedBackVO {
    private String comment_id;
    private String comment;
    private Integer from_merchant;
}
