package com.hl.childhood.service;

import com.hl.childhood.mapper.UserMapper;
import com.hl.childhood.vo.user.*;

import java.util.List;

public interface UserService<T> extends BaseService<T>, UserMapper<T> {

    UserInfoVO getUserInfo(String loginId);

    UserMoneyVO getMoneyInfo(String loginId);

    List<UserCouponsVO> getUserCoupns(String loginId);

    List<UserMoneyRecordVO> getUserMoneyRecords(String loginId);

    List<UserScoreRecordVO> getUserScoreRecords(String loginId);

    List<UserOrdersVO> getUserOrders(String loginId, String order_status);
}
