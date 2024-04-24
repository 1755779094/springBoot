package com.example.springboot001.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {

    private String code;

    private String msg;

    private T data;

    public static Result success(){
        return new Result("0","添加成功",null);
    }

    public static <E> Result<E> success(E data){
        return new Result("0","添加成功",data);
    }

    public static Result errorr(String msg){
        return  new Result("1","添加失败",null);
    }

}
