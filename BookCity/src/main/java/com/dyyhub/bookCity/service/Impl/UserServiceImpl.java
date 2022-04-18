package com.dyyhub.bookCity.service.Impl;

import com.dyyhub.bookCity.mapper.UserMapper;
import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {

//        try{
//            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            List<User> userList = mapper.findAll();
//            sqlSession.close();
//            return userList;
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public User getByUserId() {
        return null;
    }

}
