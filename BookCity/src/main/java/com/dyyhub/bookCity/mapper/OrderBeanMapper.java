package com.dyyhub.bookCity.mapper;

import com.dyyhub.bookCity.pojo.OrderBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderBeanMapper {

    List<OrderBean> getListByUserId(@Param("userId") Integer userId);

    //增加一个订单，返回自增主键的值
    void addOrder(OrderBean orderBean);

    //改变订单状态
    void updateOrderStatus();


    //获得每个订单中的每个订单数量
    Integer getTotalCount(OrderBean orderBean);

}
