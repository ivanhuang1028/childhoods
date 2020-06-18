package com.hl.childhood.service;

import com.hl.childhood.mapper.CommentMapper;
import com.hl.childhood.vo.comment.CommentFeedBackVO;
import com.hl.childhood.vo.comment.CommentImagesVO;
import com.hl.childhood.vo.comment.CommentTypeVO;
import com.hl.childhood.vo.comment.CommentVO;

import java.util.List;

public interface CommentService<T> extends BaseService<T>, CommentMapper<T> {

    List<CommentTypeVO> countCommentTypes(String goods_id);

    List<CommentVO> commentsList(String goods_id);

    List<CommentImagesVO> getCommentImages(String comment_id);

    List<CommentFeedBackVO> getCommentFeedbacks(String comment_id);
}
