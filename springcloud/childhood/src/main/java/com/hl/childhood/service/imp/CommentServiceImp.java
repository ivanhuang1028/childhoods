package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.CommentMapper;
import com.hl.childhood.service.CommentService;
import com.hl.childhood.vo.comment.CommentFeedBackVO;
import com.hl.childhood.vo.comment.CommentImagesVO;
import com.hl.childhood.vo.comment.CommentTypeVO;
import com.hl.childhood.vo.comment.CommentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("commentService")
public class CommentServiceImp<T> extends BaseServiceImp<T> implements CommentService<T> {

    @Override
    public CommentMapper<T> getMapper() {
        return (CommentMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("commentMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public List<CommentTypeVO> countCommentTypes(String goods_id) {
        return getMapper().countCommentTypes(goods_id);
    }

    @Override
    public List<CommentVO> commentsList(String goods_id) {
        return getMapper().commentsList(goods_id);
    }

    @Override
    public List<CommentImagesVO> getCommentImages(String comment_id) {
        return getMapper().getCommentImages(comment_id);
    }

    @Override
    public List<CommentFeedBackVO> getCommentFeedbacks(String comment_id) {
        return getMapper().getCommentFeedbacks(comment_id);
    }
}
