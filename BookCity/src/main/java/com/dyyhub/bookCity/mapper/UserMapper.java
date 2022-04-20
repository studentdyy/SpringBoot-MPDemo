package com.dyyhub.bookCity.mapper;

import com.dyyhub.bookCity.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public User getByUserId(Integer Id);

    public User selectOne(@Param("uname") String name, @Param("password") String password);
}
