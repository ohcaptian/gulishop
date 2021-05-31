package com.yin.order.dao;

import com.yin.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 13:43:04
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
