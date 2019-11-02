//package com.jgq.community.component;
//
//import com.jgq.community.model.User;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * @author JiGuoqing
// * @date 2019/10/31 16:06
// */
//public class Interceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null){
//            response.setContentType("text/html; charset=utf-8");
//            response.getWriter().println("<script language='javascript'>alert('请登录!');window.location='/'</script>");
//            return false;
//        }else{
//            return true;
//        }
//    }
//}
