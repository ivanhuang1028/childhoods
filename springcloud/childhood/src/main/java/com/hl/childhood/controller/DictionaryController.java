package com.hl.childhood.controller;

import com.hl.common.constants.Result;
import com.hl.childhood.module.Dictionary;
import com.hl.childhood.service.DictionaryService;
import com.hl.childhood.vo.dic.DicVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("dictionaryController")
@Scope("prototype")
public class DictionaryController extends BaseController {

    @Autowired
    private DictionaryService<Dictionary> dictionaryService;

    /**
     * 购物车 11. 配送方式列表
     * @return
     */
    @GetMapping(value = "/mods")
    public Result insertAction(HttpServletRequest request) {
        List<DicVO> vos = dictionaryService.getMods();
        return Result.getSuccResult(vos);
    }

}

