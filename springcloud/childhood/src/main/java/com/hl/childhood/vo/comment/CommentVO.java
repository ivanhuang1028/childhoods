package com.hl.childhood.vo.comment;

import com.hl.childhood.module.CommentImages;
import lombok.Data;

import java.util.List;

/**
 * 所有商品 4. 商品评价列表接口 VO
 * @author Administrator
 */
@Data
public class CommentVO {
    private String comment_id;
    private String user_id;
    private String user_name;
    private String user_icon;
    private Integer star;
    private String comment;
    private Integer from_merchant;
    private List<CommentImagesVO> comment_images;
    private List<CommentFeedBackVO> feedbacks;
}
