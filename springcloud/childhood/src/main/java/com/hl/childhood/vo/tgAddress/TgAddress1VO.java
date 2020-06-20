package com.hl.childhood.vo.tgAddress;

import lombok.Data;

/**
 * 购物车 4. 收货地址列表 VO
 * @author Administrator
 */
@Data
public class TgAddress1VO {
    private String tga_id;
    private String user_id;
    private String tg_name;
    private String tg_phone;
    private String tg_address;
    private Integer is_default;
}
