//package com.jgq.community.config;
//
//import com.jgq.community.component.Interceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @author JiGuoqing
// * @date 2019/10/31 16:08
// */
//@Configuration
//public class MyMvcConfig implements WebMvcConfigurer {
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        WebMvcConfigurer adapter = new WebMvcConfigurer() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new Interceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/","/callback","");
//            }
//        };
//        return adapter;
//    }
//}
