package com.jgq.community.dto;

import lombok.Data;

/**
 * @author JiGuoqing
 * @date 2019/10/29 21:19
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
