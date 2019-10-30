package com.jgq.community.controller;

import com.jgq.community.model.User;
import com.jgq.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author JiGuoqing
 * @date 2019/10/29 19:41
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest){
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userService.findUserByToken(token);
                if (user != null){
                    httpServletRequest.getSession().setAttribute("user",user);
                }
            }
        }
        return "index";
    }
}
