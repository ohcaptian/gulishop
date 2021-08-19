package com.yin.coupon.controller;

import com.yin.common.utils.PageUtils;
import com.yin.common.utils.R;
import com.yin.coupon.entity.CouponEntity;
import com.yin.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 优惠券信息
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 14:45:58
 */

/**
 * nacos 配置 注解@RefreshScope Pom文件中引入依赖
 * 创建bootstrap.properties
 * 配置中心添加数据集
 * 可以基于环境和微服务系统进行配置隔离
 * 利用命名空间作环境隔离
 * 可以给每个微服务创建各自的命名空间
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @Value("${coupon.user.name}")
    private String name;
    @Value("${coupon.user.age}")
    private Integer age;
    /**
     *测试接口
     */
    @RequestMapping(value = "member/list",method = RequestMethod.GET)
    public R MemberCoupon(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("优惠信息");
        //asList() 该方法是将数组转化成List集合的方法。 此方法生成的list长度不可变
        return R.ok().put("coupons",Arrays.asList(couponEntity));
    }
    /**
     * nacos-config 测试
     */
    @RequestMapping("test")
    public R test(){
        return R.ok().put("name",name).put("age",age);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
