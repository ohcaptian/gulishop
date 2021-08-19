package com.yin.product.controller;

import com.yin.common.utils.R;
import com.yin.product.entity.CategoryEntity;
import com.yin.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 商品三级分类
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 14:23:00
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表  以树形结构展示
     */
    @RequestMapping("/list/tree")
    public R list(@RequestParam Map<String, Object> params){


        List<CategoryEntity> categoryEntities = categoryService.listWithTree();
        //PageUtils page = categoryService.queryPage(params);
        //树形结构

        return R.ok().put("data", categoryEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     * RequestBody post请求 由SpringMVC自动转化
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){

		categoryService.updateById(category);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){
//		categoryService.removeByIds(Arrays.asList(catIds));
        categoryService.removeMenusByIds(Arrays.asList(catIds));
        return R.ok();
    }

}
