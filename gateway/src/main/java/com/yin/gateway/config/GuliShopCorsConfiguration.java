package com.yin.gateway.config;/**
 * @author 17694
 * @date 2021/07/31
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @ClassName : CorsConfiguration 
 * @Description : 跨域配置  
 */
@Configuration
public class GuliShopCorsConfiguration {
            @Bean
            public CorsWebFilter corsWebFilter(){
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                CorsConfiguration config = new CorsConfiguration();
                //1 配置跨域
                config.addAllowedHeader("*");
                config.addAllowedMethod("*");
                config.addAllowedOrigin("*");
                config.setAllowCredentials(true);
                source.registerCorsConfiguration("/**",config);
                return new CorsWebFilter(source);
            }
}
