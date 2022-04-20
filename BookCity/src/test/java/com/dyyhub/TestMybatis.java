package com.dyyhub;

import com.dyyhub.bookCity.mapper.BookMapper;
import com.dyyhub.bookCity.mapper.CartItemMapper;
import com.dyyhub.bookCity.mapper.UserMapper;
import com.dyyhub.bookCity.mapper.testMapper;
import com.dyyhub.bookCity.pojo.Book;
import com.dyyhub.bookCity.pojo.CartItem;
import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.pojo.test;
import com.github.pagehelper.PageHelper;
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
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CartItemMapper cartItemMapper;

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
    //分页测试
    @Test
    public void  test7(){
        PageHelper.startPage(1,3);
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }

    //多属性注入测试
    @Test
    public void  test11(){

        System.out.println(userMapper.selectOne("kate","ok"));
    }

    @Test
    public void  test12(){
        List<Book> bookList = bookMapper.getBookList();
        for (Book book:bookList) {
            System.out.println(book);
        }
    }
    @Test
    public void  test14(){
        List<CartItem> cartItemList = cartItemMapper.getListByUserID(1);
        for (CartItem cartItem:cartItemList) {
            System.out.println(cartItem);
            //System.out.println(cartItem.getBook().getBookImg());
        }
    }
    @Test
    public void  test15(){
        CartItem cartItem = new CartItem(18,8,1,1);
        cartItemMapper.updateCartItem(cartItem);
    }
    @Test
    public void  test16(){
        CartItem cartItem = new CartItem(8,1,2);
        cartItemMapper.add(cartItem);
    }

    //多对多查询，通过遍历中间表集合，然后封装对象达成！
    @Test
    public void  test17(){

        List<CartItem> cartItemList = cartItemMapper.getListByUserID(1);
        for(CartItem cartItem : cartItemList){
            Book Book = bookMapper.getBookById(cartItem.getBookID());
//            User user = userMapper.getByUserId(1);
            cartItem.setBook(Book);
//            cartItem.setUser(user);
            System.out.println(cartItem);
        }


    }
}
