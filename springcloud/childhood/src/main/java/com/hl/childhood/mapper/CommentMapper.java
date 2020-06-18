package com.hl.childhood.mapper;

import com.hl.childhood.vo.comment.CommentFeedBackVO;
import com.hl.childhood.vo.comment.CommentImagesVO;
import com.hl.childhood.vo.comment.CommentTypeVO;
import com.hl.childhood.vo.comment.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface CommentMapper<T> extends BaseMapper<T> {

    List<CommentTypeVO> countCommentTypes(@Param("goods_id") String goods_id);

    List<CommentVO> commentsList(@Param("goods_id") String goods_id);

    List<CommentImagesVO> getCommentImages(@Param("comment_id") String comment_id);

    List<CommentFeedBackVO> getCommentFeedbacks(@Param("comment_id") String comment_id);

}
