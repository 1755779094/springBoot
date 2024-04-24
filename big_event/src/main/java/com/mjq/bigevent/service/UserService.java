package com.mjq.bigevent.service;

import com.mjq.bigevent.pojo.User;

public interface UserService {
    void add(String userName, String password);

    User findUser(String userName);
}
