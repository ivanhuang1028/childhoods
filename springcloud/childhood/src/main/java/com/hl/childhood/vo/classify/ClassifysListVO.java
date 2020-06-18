package com.hl.childhood.vo.classify;

import lombok.Data;

import java.util.List;

/**
 * 首页 4. 首页商品分类列表展示 VO
 * @author Administrator
 */
@Data
public class ClassifysListVO {
    private String classify_id;
    private String classify_name;
    private String classify_icon;
    List<ClassifysGoodsVO> goodslist;
}
