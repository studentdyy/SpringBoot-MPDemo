package com.dyyhub.bookCity.service.Impl;

import com.dyyhub.bookCity.mapper.CartItemMapper;
import com.dyyhub.bookCity.mapper.OrderBeanMapper;
import com.dyyhub.bookCity.mapper.OrderItemMapper;
import com.dyyhub.bookCity.pojo.*;
import com.dyyhub.bookCity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    OrderBeanMapper orderBeanMapper;
    @Autowired
    CartItemMapper cartItemMapper;

    @Override
    @Transactional
    public void addOrderBean(User user) {
        //三步走，第一步增加一个订单项目

        OrderBean orderBean = new OrderBean();

        Cart cart = user.getCart();

        Date currTime = new Date();

        int year = currTime.getYear();
        int month = currTime.getMonth() ;
        int day = currTime.getDate();
        int hour = currTime.getHours();
        int min = currTime.getMinutes() ;
        int sec = currTime.getSeconds() ;
        orderBean.setOrderNo(UUID.randomUUID().toString()+"_"+year+month+day+hour+min+sec);
        orderBean.setOrderDate(currTime);
        orderBean.setOrderUser(user.getId());
        orderBean.setOrderMoney(cart.getTotalMoney());
        orderBean.setOrderStatus(0);
        orderBean.setTotalCount(cart.getTotalBookCount());
        orderBeanMapper.addOrder(orderBean);

        //第二步将订单项目中的OrderList填充一下
        Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        if(cartItemMap!=null){
            for(CartItem cartItem : cartItemMap.values()){
                OrderItem orderItem =  new OrderItem();
                orderItem.setBook(cartItem.getBookID());
                orderItem.setOrderBean(orderBean.getId());
                orderItem.setBuyCount(cartItem.getBuyCount());
                orderItemMapper.addOrderItem(orderItem);
            }
            //第三步购物车清空
            for(CartItem cartItem : cartItemMap.values()){
                cartItemMapper.deleteCartItem(cartItem);
            }
        }
    }

//    @Override
//    public void addOrderItem() {
//
//    }

    @Override
    public List<OrderBean> showOrderBeanList(Integer userId) {

        List<OrderBean> orderBeanList = orderBeanMapper.getListByUserId(userId);
        for(OrderBean orderBean : orderBeanList){

            orderBean.setTotalCount(orderBeanMapper.getTotalCount(orderBean));
        }
        return orderBeanList;
    }

    @Override
    public List<OrderItem> showOrderItemList(Integer orderId) {
        return orderItemMapper.getOrderListByOrderBeanId(orderId);
    }
}
