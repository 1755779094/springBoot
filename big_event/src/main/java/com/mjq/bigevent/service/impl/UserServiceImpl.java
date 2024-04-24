package com.mjq.bigevent.service.impl;

import com.mjq.bigevent.mapper.UserMapper;
import com.mjq.bigevent.pojo.User;
import com.mjq.bigevent.service.UserService;
import com.mjq.bigevent.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(String userName, String password) {
        String md5String = Md5Util.getMD5String(password);
        userMapper.add(userName,md5String);
    }

    @Override
    public User findUser(String userName) {
        return userMapper.findUser(userName);
    }
}
