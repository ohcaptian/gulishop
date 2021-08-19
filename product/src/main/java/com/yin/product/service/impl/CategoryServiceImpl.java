package com.yin.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yin.common.utils.PageUtils;
import com.yin.common.utils.Query;
import com.yin.product.dao.CategoryDao;
import com.yin.product.entity.CategoryEntity;
import com.yin.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 查出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        // 组成树形结构
        List<CategoryEntity> levelMenus = categoryEntities.stream().filter(CategoryEntity ->
                CategoryEntity.getParentCid() == 0).map((menu)->{
            menu.setChild(getChild(menu,categoryEntities));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) -  (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return levelMenus;
    }

    @Override
    public void removeMenusByIds(List<Long> ids) {
        //todo  // 检查删除菜单是否被引用
                baseMapper.deleteBatchIds(ids);
    }

    //递归查找子菜单
    private List<CategoryEntity> getChild(CategoryEntity root,List<CategoryEntity> all){
        List<CategoryEntity> child = all.stream().filter(categoryEntity ->
            categoryEntity.getParentCid() == root.getCatId()
        ).map(categoryEntity -> {
            //找到子菜单
            categoryEntity.setChild(getChild(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            //菜单的排序
            return (menu1.getSort()==null?0:menu1.getSort()) -  (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return child;
    }

}