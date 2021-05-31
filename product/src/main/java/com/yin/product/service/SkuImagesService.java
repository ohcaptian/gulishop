package com.yin.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yin.common.utils.PageUtils;
import com.yin.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-26 15:28:23
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

