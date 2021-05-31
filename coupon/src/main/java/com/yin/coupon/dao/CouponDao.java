package com.yin.coupon.dao;

import com.yin.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 14:45:58
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
