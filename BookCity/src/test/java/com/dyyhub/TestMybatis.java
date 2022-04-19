package com.dyyhub;

import com.dyyhub.bookCity.mapper.UserMapper;
import com.dyyhub.bookCity.mapper.testMapper;
import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.pojo.test;
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
public class TestMybatis {

    @Autowired
    UserMapper userMapper;
    @Autowired
    SqlSession sqlSession;
    @Autowired
    testMapper testMapper;


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
    @Test
    public void  test8(){
        test test = new test("jex",6000);
        testMapper.insert(test);
        System.out.println(test);
    }
    @Test
    public void  test9(){
        testMapper.deleteById(3);
    }
    @Test
    public void  test10(){
        test test = new test("jex",3);
        test.setId(4);
        testMapper.updateTest(test);
    }
    @Test
    public void  test5(){
        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = UserMapper.findAll();
        for(User user : userList){
            System.out.println(user);
        }
    }
    @Test
    public void  test6(){
        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
        User user = UserMapper.getByUserId(1);

        System.out.println(user);

    }
    @Test
    public void  test7(){

        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
        User user = UserMapper.getByUserId(1);

        System.out.println(user);

    }
}
