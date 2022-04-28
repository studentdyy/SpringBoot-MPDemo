package com.dyyhub.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyyhub.pojo.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userDao extends BaseMapper<user> {
}
