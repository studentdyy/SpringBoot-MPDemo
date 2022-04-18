package com.dyyhub.bookCity.mapper;

import com.dyyhub.bookCity.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public User getByUserId(@Param("userid") Long userId);
}
