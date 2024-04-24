package com.example.springboot001.service;

import com.example.springboot001.pojo.Tdept;

import java.util.List;

public interface TdeptService {

    public List<Tdept> findUser();

    void add(String userName,String pwd);
}
