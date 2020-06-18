package com.hl.childhood.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ivan.huang
 */
@Data
public class Comment implements Serializable {

    //评论标识
    private String comment_id;

    //订单标识，已评价状态的
    private String order_id;

    //评价类型
    private String comment_type;

    //星级评级，最高5，最低1
    private Integer star;

    //评价内容
    private String comment;

    //上级评论标识
    private String comment_pid;

    //所有上级评论标识
    private Date comment_pids;

    //1为来自商家的评论，0为来自客户的评论
    private Integer from_merchant;

    //评论时间
    private Date create_time;

}