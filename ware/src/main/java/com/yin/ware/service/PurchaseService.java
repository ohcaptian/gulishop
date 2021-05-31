package com.yin.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yin.common.utils.PageUtils;
import com.yin.ware.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 14:52:51
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

