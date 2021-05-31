package com.yin.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yin.common.utils.PageUtils;
import com.yin.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 13:43:04
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

