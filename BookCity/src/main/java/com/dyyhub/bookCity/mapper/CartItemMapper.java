package com.dyyhub.bookCity.mapper;

import com.dyyhub.bookCity.pojo.CartItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartItemMapper {
    //增加一个购物车项
    void add(CartItem cartItem);

    //修改购物车项
    void updateCartItem(CartItem cartItem);

//    //根据id显示用户购物车列表
//    List<CartItem> getCartItemByUserBeanId(@Param("id") Integer id);

    //根据用户id获取购物车项
    List<CartItem> getListByUserID(@Param("id") Integer id);
}
