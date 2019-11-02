package com.jgq.community.service;

import com.jgq.community.dto.QuestionDTO;
import com.jgq.community.model.Question;

import java.util.List;

/**
 * @author JiGuoqing
 * @date 2019/10/31 10:09
 */
public interface QuestionService {
     Integer createQuestion(Question question);

    List<QuestionDTO> getAll();
}
