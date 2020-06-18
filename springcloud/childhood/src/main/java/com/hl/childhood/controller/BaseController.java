package com.hl.childhood.controller;

import com.hl.common.constants.Constants;
import com.hl.common.util.JwtHelper;
import com.hl.childhood.properties.JwtConfig;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * 所有的Controller类需要继承此类
 *
 * @author ivan.huang
 */
@Slf4j
public abstract class BaseController {

    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 获取登录者的用户标识
     *
     * @param request
     * @return
     */
    public String getLoginerId(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        Claims claims = JwtHelper.parseJWT(auth, jwtConfig.getEncodedKey());
        String userId = (String)claims.get("user_id");
        return userId;
    }


    /**
     * 获取用户名
     *
     * @param request
     * @return
     */
    public String getLoginerEname(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        Claims claims = JwtHelper.parseJWT(auth, jwtConfig.getEncodedKey());
        String user_name = (String)claims.get("user_name");
        return user_name;
    }

    /**
     * 获取用户的店铺标识
     *
     * @param request
     * @return
     */
    public String getLoginerShopId(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        Claims claims = JwtHelper.parseJWT(auth, jwtConfig.getEncodedKey());
        String shop_id = (String)claims.get("shop_id");
        return shop_id;
    }

}
