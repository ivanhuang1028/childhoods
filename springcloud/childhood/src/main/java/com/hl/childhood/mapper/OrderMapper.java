package com.hl.childhood.mapper;

import com.hl.childhood.vo.order.OrderCouponVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface OrderMapper<T> extends BaseMapper<T> {

    List<OrderCouponVO> getOrderCoupon(@Param("promotionId") String promotionId, @Param("price") BigDecimal price, @Param("loginId")String loginId);

}
