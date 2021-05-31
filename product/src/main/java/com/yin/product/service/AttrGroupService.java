package com.yin.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yin.common.utils.PageUtils;
import com.yin.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-26 15:28:23
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

