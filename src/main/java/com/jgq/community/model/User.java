package com.jgq.community.model;

import lombok.Data;

/**
 * @author JiGuoqing
 * @date 2019/10/30 17:21
 */
@Data
public class User {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
