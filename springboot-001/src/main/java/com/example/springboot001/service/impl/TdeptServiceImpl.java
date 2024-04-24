package com.example.springboot001.service.impl;

import com.example.springboot001.mapper.tdeptMapper;
import com.example.springboot001.pojo.Tdept;
import com.example.springboot001.service.TdeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TdeptServiceImpl implements TdeptService {

    @Autowired
    private tdeptMapper mapper;

    @Override
    public List<Tdept> findUser(){
        return mapper.findUser();
    }

    @Override
    public void add(String userName, String pwd) {
        mapper.add(userName,pwd);
    }
}
