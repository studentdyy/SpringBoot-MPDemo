package com.dyyhub;

import com.dyyhub.bookCity.mapper.UserMapper;
import com.dyyhub.bookCity.mapper.testMapper;
import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {

    @Autowired
    UserMapper userMapper;
    @Autowired
    SqlSession sqlSession;


    @Test
    public void  test1(){
        Method[] methods = userMapper.getClass().getMethods();
        for (Method method : methods){
            String name = method.getName();
            System.out.println(name);

        }
    }
    @Test
    public void  test2(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        System.out.println(userList);
        sqlSession.close();
    }


    @Test
    public void  test3(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            testMapper testMapper = sqlSession.getMapper(testMapper.class);
            List<com.dyyhub.bookCity.pojo.test> testList =testMapper.selectAll();

            System.out.println(testList);
            sqlSession.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void  test4(){
        testMapper mapper = sqlSession.getMapper(testMapper.class);
        List<com.dyyhub.bookCity.pojo.test> tests = mapper.selectAll();
        System.out.println(tests);
    }
}
