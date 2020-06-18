package com.hl.childhood.controller;

import com.hl.childhood.module.Goods;
import com.hl.childhood.module.SearchHis;
import com.hl.childhood.service.GoodsService;
import com.hl.childhood.service.SearchHisService;
import com.hl.childhood.vo.promotion.PromotionSeckillVO;
import com.hl.common.constants.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("searchHisController")
@Scope("prototype")
public class SearchHisController extends BaseController {

    @Autowired
    private SearchHisService<SearchHis> searchHisService;

    /**
     * 首页 8. 搜索历史接口
     * @return
     */
    @GetMapping(value = "/searchHiss")
    public Result searchHiss(HttpServletRequest request) {
        String loginer = getLoginerId(request);
        SearchHis tmp = new SearchHis();
        tmp.setUser_id(loginer);
        List<SearchHis> list = searchHisService.selectByBlurryT(tmp);
        return Result.getSuccResult(list);
    }

    /**
     * 首页 9. 搜索历史清空接口
     * @return
     */
    @DeleteMapping(value = "/searchHiss")
    public Result searchHissDelete(HttpServletRequest request) {
        try {
            String loginer = getLoginerId(request);
            SearchHis tmp = new SearchHis();
            tmp.setUser_id(loginer);
            searchHisService.deleteByBlurryT(tmp);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.getSuccResult();
    }



}

