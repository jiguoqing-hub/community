package com.jgq.community.service.impl;

import com.jgq.community.mapper.QuestionMapper;
import com.jgq.community.model.Question;
import com.jgq.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JiGuoqing
 * @date 2019/10/31 10:10
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public Integer createQuestion(Question question) {
        return questionMapper.createQuestion(question);
    }
}
