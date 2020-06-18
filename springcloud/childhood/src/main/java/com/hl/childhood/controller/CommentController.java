package com.hl.childhood.controller;

import com.github.pagehelper.PageHelper;
import com.hl.childhood.module.Comment;
import com.hl.childhood.service.CommentService;
import com.hl.childhood.vo.comment.CommentTypeVO;
import com.hl.childhood.vo.comment.CommentVO;
import com.hl.childhood.vo.goods.GoodsInfoVO;
import com.hl.childhood.vo.goods.GoodsVO;
import com.hl.childhood.vo.page.PageVO;
import com.hl.childhood.vo.page.ResultsPageVO;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("commentController")
@Scope("prototype")
public class CommentController extends BaseController {

    @Autowired
    private CommentService<Comment> commentService;

    /**
     * 所有商品 3. 商品评价类型及统计接口
     * @return
     */
    @GetMapping(value = "/comment_types/{goods_id}")
    public Result goodsList(HttpServletRequest request, @PathVariable("goods_id") String goods_id){
        if(StringUtils.isEmpty(goods_id)){
            return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 goods_id");
        }
        List<CommentTypeVO> vos = new ArrayList<>();
        vos = commentService.countCommentTypes(goods_id);
        return Result.getSuccResult(vos);
    }

    /**
     * 所有商品 4. 商品评价列表接口
     * @return
     */
    @GetMapping(value = "/comments/{goods_id}")
    public Result commentsList(HttpServletRequest request, PageVO pageVO, @PathVariable("goods_id") String goods_id){
        List<CommentVO> commentVOS = new ArrayList<>();
        // 分页
        if(pageVO.getOpenPage()){
            PageHelper.startPage(pageVO.getPageIndex(), pageVO.getPageSize());
        }
        commentVOS = commentService.commentsList(goods_id);
        for(CommentVO vo : commentVOS){
            vo.setComment_images(commentService.getCommentImages(vo.getComment_id()));
            vo.setFeedbacks(commentService.getCommentFeedbacks(vo.getComment_id()));
        }

        ResultsPageVO resultsPageVO = ResultsPageVO.init(commentVOS, pageVO);
        return Result.getSuccResult(resultsPageVO);
    }


}

