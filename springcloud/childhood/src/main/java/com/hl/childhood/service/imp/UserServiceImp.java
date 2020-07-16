package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.UserMapper;
import com.hl.childhood.service.UserService;
import com.hl.childhood.vo.user.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("userService")
public class UserServiceImp<T> extends BaseServiceImp<T> implements UserService<T> {

    @Override
    public UserMapper<T> getMapper() {
        return (UserMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("userMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public UserInfoVO getUserInfo(String loginId) {
        return getMapper().getUserInfo(loginId);
    }

    @Override
    public UserMoneyVO getMoneyInfo(String loginId) {
        return getMapper().getMoneyInfo(loginId);
    }

    @Override
    public List<UserCouponsVO> getUserCoupns(String loginId) {
        return getMapper().getUserCoupns(loginId);
    }

    @Override
    public List<UserMoneyRecordVO> getUserMoneyRecords(String loginId) {
        return getMapper().getUserMoneyRecords(loginId);
    }

    @Override
    public List<UserScoreRecordVO> getUserScoreRecords(String loginId) {
        return getMapper().getUserScoreRecords(loginId);
    }

    @Override
    public List<UserOrdersVO> getUserOrders(String loginId, String order_status) {
        return getMapper().getUserOrders(loginId, order_status);
    }
}
