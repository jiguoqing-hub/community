package com.jgq.community.dto;

import lombok.Data;

/**
 * @author JiGuoqing
 * @date 2019/10/29 20:50
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
