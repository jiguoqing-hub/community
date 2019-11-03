package com.jgq.community.controller;
import com.jgq.community.dto.PaginationDTO;
import com.jgq.community.dto.QuestionDTO;
import com.jgq.community.model.User;
import com.jgq.community.service.QuestionService;
import com.jgq.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author JiGuoqing
 * @date 2019/10/29 19:41
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest, Model model,
                        @RequestParam(value = "page",defaultValue = "1")Integer page,
                        @RequestParam(value = "size",defaultValue = "6")Integer size){
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null){
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userService.findUserByToken(token);
                    if (user != null){
                        httpServletRequest.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        PaginationDTO pagination = questionService.getAllByPage(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
