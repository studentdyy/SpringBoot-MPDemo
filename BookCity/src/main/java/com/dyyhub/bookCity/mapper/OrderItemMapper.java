package com.dyyhub.bookCity.mapper;

import com.dyyhub.bookCity.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    //根据orderBean的id获得OrderList
    List<OrderItem> getOrderListByOrderBeanId(@Param("orderBeanId") Integer orderBeanId);
    void addOrderItem(OrderItem orderItem);


}
