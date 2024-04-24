package com.mjq.bigevent.mapper;

import com.mjq.bigevent.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(username,password,create_time,update_time) values(#{userName},#{password},now(),now())")
    void add(String userName, String password);

    @Select("select * from user where username = #{userName}")
    User findUser(String userName);
}
