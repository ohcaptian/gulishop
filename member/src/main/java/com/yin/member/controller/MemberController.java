package com.yin.member.controller;

import com.yin.common.utils.PageUtils;
import com.yin.common.utils.R;
import com.yin.member.entity.MemberEntity;
import com.yin.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 会员
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 15:08:49
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
//    @Autowired
//    private CouponFeignClient couponFeignClient;
/**
 * feign远程调用测试接口
 */
//        @RequestMapping("/coupon")
//        public R test(){
//            MemberEntity memberEntity = new MemberEntity();
//            memberEntity.setNickname("张三");
//            R menbercoupon = couponFeignClient.MemberCoupon();
//
//            return R.ok().put("member",memberEntity).put("coupon",menbercoupon.get("coupon"));
//        }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
