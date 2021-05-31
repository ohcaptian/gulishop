package com.yin.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yin.common.utils.PageUtils;
import com.yin.coupon.entity.CouponSpuCategoryRelationEntity;

import java.util.Map;

/**
 * 优惠券分类关联
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 14:45:58
 */
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

