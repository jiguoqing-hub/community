package com.jgq.community.service;

import com.jgq.community.model.User;

/**
 * @author JiGuoqing
 * @date 2019/10/30 18:02
 */
public interface UserService {
    void insertUser(User user);
    User findUserByToken(String token);
}
