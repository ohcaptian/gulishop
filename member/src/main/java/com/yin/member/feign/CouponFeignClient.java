package com.yin.member.feign;

/**
 * @author 17694
 * @date 2021/05/28
 **/

import com.yin.common.utils.R;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 远程调用coupon微服务接口
 */
@FeignClient("coupon")
public interface CouponFeignClient {
    @RequestMapping(value = "coupon/coupon/member/list",method = RequestMethod.GET)
    R MemberCoupon();
}
