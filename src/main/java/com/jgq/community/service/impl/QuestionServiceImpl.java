package com.jgq.community.service.impl;

import com.jgq.community.dto.QuestionDTO;
import com.jgq.community.mapper.QuestionMapper;
import com.jgq.community.mapper.UserMapper;
import com.jgq.community.model.Question;
import com.jgq.community.model.User;
import com.jgq.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiGuoqing
 * @date 2019/10/31 10:10
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer createQuestion(Question question) {
        return questionMapper.createQuestion(question);
    }

    @Override
    public List<QuestionDTO> getAll() {
        List<Question> questionList = questionMapper.getAll();
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        for (Question question: questionList) {
            User user = userMapper.findUserById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOs.add(questionDTO);
        }
        return questionDTOs;
    }
}
