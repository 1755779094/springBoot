package com.example.springboot001.mapper;

import com.example.springboot001.pojo.Tdept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface tdeptMapper {

    @Select("select * from t_user")
    List<Tdept> findUser();

    @Insert("insert into t_user(username,password) values (#{userName},#{pwd})")
    void add(String userName,String pwd);
}
