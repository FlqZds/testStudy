package com.ddjc.teststudy.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class myInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

    return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.err.println("现已拦截请求，地址为controller执行之后，modelAndView渲染之前");
        if (modelAndView != null&& modelAndView.getModelMap().get("s")!= null){
            System.out.println("这是我拦截的东西：");
        }else {
            System.out.println("modelAndView 为null");
        }
    }

    // 这个也是从controller 出来之后，但是modelandview 已经被解析了
    // 所以这个时候修改modelandview 已经晚了
    // controller 不管跑不跑出异常  都会进入这个方法
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
