package com.yin.product.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yin.common.utils.PageUtils;
import com.yin.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-26 15:28:23
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenusByIds(List<Long> ids);
}

