package com.yin.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yin.common.utils.PageUtils;
import com.yin.ware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 14:52:51
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

