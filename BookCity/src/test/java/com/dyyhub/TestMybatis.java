package com.dyyhub;

import com.dyyhub.bookCity.mapper.*;
import com.dyyhub.bookCity.pojo.*;
import com.dyyhub.bookCity.service.CartService;
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
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.DateUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Autowired
    OrderBeanMapper orderBeanMapper;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    CartService cartService;


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

        List<CartItem> cartItemList = cartItemMapper.getListByUserID(2);
        for(CartItem cartItem : cartItemList){
            Book Book = bookMapper.getBookById(cartItem.getBookID());
//            User user = userMapper.getByUserId(1);
            cartItem.setBook(Book);
//            cartItem.setUser(user);
            System.out.println(cartItem);
        }
    }
    @Test
    public void  test18(){
        List<OrderBean> orderBeanList = orderBeanMapper.getListByUserId(1);
        for (OrderBean orderBean : orderBeanList){
            System.out.println(orderBean);
        }
    }

    @Test
    public void  test19(){
        List<OrderItem> OrderItemList = orderItemMapper.getOrderListByOrderBeanId(4);
        for (OrderItem orderItem : OrderItemList){
            System.out.println(orderItem);
        }
    }
    @Test
    public void  test20(){
        OrderBean orderBean = new OrderBean();
        Date data = new Date();
        orderBean.setOrderUser(1);
        orderBean.setOrderMoney(500.0);
        orderBean.setOrderStatus(0);
        orderBean.setOrderDate(data);
        orderBean.setOrderNo("b521cd49ab2943f0bbc0630c95978f1c_2021102511312112");
        orderBeanMapper.addOrder(orderBean);
        System.out.println(orderBean);
    }
    //时间格式化
    @Test
    public void  test21(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");;
        LocalDateTime now = LocalDateTime.now();
        String currTime = dateTimeFormatter.format(now);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currTime1 = new Date();
        System.out.println(currTime1);

//        Date date = new Date();
//        System.out.println(date);
    }
    @Test
    public void  test22(){
        User user = new User();
        user.setId(1);
        Cart cart = cartService.getCartByUser(user);
        Map<Integer,CartItem> cartItemMap = cart.getCartItemMap();
        for(CartItem cartItem : cartItemMap.values()){
            System.out.println(cartItem);
        }
    }
    //获取订单的订单数量
    @Test
    public void  test23(){
        OrderBean orderBean = new OrderBean();
        orderBean.setId(28);
        Integer totalCount = orderBeanMapper.getTotalCount(orderBean);
        System.out.println(totalCount);
    }
}
