package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ivan.huang
 */
@Data
public class CommentImages implements Serializable {

    //评论图像标识
    private String ci_id;

    //评论标识
    private String comment_id;

    //图像标识
    private String image_id;

    //序号
    private String ci_seq;

}