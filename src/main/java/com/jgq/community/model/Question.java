package com.jgq.community.model;


import lombok.Data;

/**
 * @author JiGuoqing
 * @date 2019/10/31 9:57
 */
@Data
public class Question {
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
}
