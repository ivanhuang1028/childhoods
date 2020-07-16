package com.hl.childhood.mapper;

import com.hl.childhood.vo.user.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface UserMapper<T> extends BaseMapper<T> {

    UserInfoVO getUserInfo(@Param("loginId") String loginId);

    UserMoneyVO getMoneyInfo(@Param("loginId") String loginId);

    List<UserCouponsVO> getUserCoupns(@Param("loginId") String loginId);

    List<UserMoneyRecordVO> getUserMoneyRecords(@Param("loginId") String loginId);

    List<UserScoreRecordVO> getUserScoreRecords(@Param("loginId") String loginId);

    List<UserOrdersVO> getUserOrders(@Param("loginId") String loginId, @Param("order_status") String order_status);

}
