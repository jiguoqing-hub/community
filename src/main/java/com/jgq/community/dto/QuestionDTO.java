package com.jgq.community.dto;

import com.jgq.community.model.User;
import lombok.Data;

/**
 * @author JiGuoqing
 * @date 2019/11/2 18:41
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private String tag;
    private User user;
}
