package com.jgq.community.service.impl;

import com.jgq.community.mapper.UserMapper;
import com.jgq.community.model.User;
import com.jgq.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JiGuoqing
 * @date 2019/10/30 18:04
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    @Override
    public void insertUser(User user) {
          userMapper.insertUser(user);
    }
}
