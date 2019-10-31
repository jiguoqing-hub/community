package com.jgq.community.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jgq.community.model.Question;
import com.jgq.community.model.User;
import com.jgq.community.service.QuestionService;
import com.jgq.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JiGuoqing
 * @date 2019/10/30 21:38
 */
@Controller
public class PublishController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public void doPublish(@RequestParam("title")String title,
                            @RequestParam("description")String description,
                            @RequestParam("tag")String tag,
                            HttpServletRequest httpServletRequest,
                            HttpServletResponse httpServletResponse) throws IOException {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        Integer flag = questionService.createQuestion(question);
        if (flag > 0){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",200);
            httpServletResponse.setContentType("application/json; charset=utf-8");
            httpServletResponse.getWriter().append(jsonObject.toJSONString());
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",400);
            httpServletResponse.setContentType("application/json; charset=utf-8");
            httpServletResponse.getWriter().append(jsonObject.toJSONString());
        }
    }
}
