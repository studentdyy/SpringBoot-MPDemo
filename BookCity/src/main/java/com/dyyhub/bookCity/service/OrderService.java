package com.dyyhub.bookCity.service;

import com.dyyhub.bookCity.pojo.Cart;
import com.dyyhub.bookCity.pojo.OrderBean;
import com.dyyhub.bookCity.pojo.OrderItem;
import com.dyyhub.bookCity.pojo.User;

import java.util.List;

public interface OrderService {
    void addOrderBean(User user);
//    void addOrderItem();
    List<OrderBean> showOrderBeanList(Integer userId);
    List<OrderItem>  showOrderItemList(Integer orderId);
}
