package com.hl.childhood.vo.tgAddress;

import com.hl.childhood.vo.shopingCar.ShopingCarVO;
import lombok.Data;

import java.util.List;

/**
 * 购物车 3. 默认收货地址接口 VO
 * @author Administrator
 */
@Data
public class TgAddressVO {
    private String tga_id;
    private String user_id;
    private String tg_name;
    private String tg_phone;
    private String tg_address;
}
