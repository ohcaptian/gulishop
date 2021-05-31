package com.yin.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yin.common.utils.PageUtils;
import com.yin.product.entity.SpuImagesEntity;

import java.util.Map;

/**
 * spu图片
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-26 15:28:22
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

