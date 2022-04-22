package com.dyyhub.bookCity.service.Impl;

import com.dyyhub.bookCity.mapper.UserMapper;
import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userMapper.findAll();
    }

    @Override
    public User getByUserId() {
        return null;
    }

    @Override
    public User login(String name, String password) {
        return userMapper.selectOne(name,password);
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }

}
