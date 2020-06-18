package com.hl.childhood.controller;

import com.hl.childhood.module.SearchHis;
import com.hl.childhood.module.ShopingCar;
import com.hl.childhood.service.ShopingCarService;
import com.hl.common.constants.Result;
import com.hl.common.constants.ResultCode;
import com.hl.common.util.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@RestController("shopingCarController")
@Scope("prototype")
public class ShopingCarController extends BaseController {

    @Autowired
    private ShopingCarService<ShopingCar> shopingCarService;

    /**
     * 所有商品 6. 加入购物车接口
     * 完成第二块
     * @return
     */
    @PostMapping(value = "/shoping_cars")
    public Result shopingCars(HttpServletRequest request, @RequestBody HashMap<String, String> paramMap){
        try {
            if(StringUtils.isEmpty(paramMap.get("spe_id"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 spe_id");
            }
            if(StringUtils.isEmpty(paramMap.get("sc_price"))){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 sc_price");
            }
            if(paramMap.get("sc_num") == null){
                return Result.getFalseResult(ResultCode.PARAMETER_ERROR, "缺参数 sc_num");
            }
            ShopingCar shopingCar = new ShopingCar();
            shopingCar.setSc_id(UUIDGenerator.generate());
            shopingCar.setSpe_id(paramMap.get("spe_id"));
            shopingCar.setSc_price(BigDecimal.valueOf(Double.valueOf(paramMap.get("sc_price"))));
            shopingCar.setSc_num(Integer.valueOf(paramMap.get("sc_num")));
            if(!StringUtils.isEmpty(paramMap.get("promotion_id"))){
                shopingCar.setPromotion_id(paramMap.get("promotion_id"));
            }
            shopingCar.setUser_id(getLoginerId(request));
            shopingCarService.insert(shopingCar);

        }catch (Exception e){
            log.error(e.getMessage());
            return Result.getFalseResult(ResultCode.FAILURE, e.getMessage());
        }
        return Result.getSuccResult();
    }



}

