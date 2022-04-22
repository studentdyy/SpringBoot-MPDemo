package com.dyyhub.bookCity.mapper;

import com.dyyhub.bookCity.pojo.CartItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartItemMapper {
    //增加一个购物车项
    void add(CartItem cartItem);

    //修改购物车项
    void updateCartItem(CartItem cartItem);

    //增加购买数量
    void increaseBuyCount(Integer cartItemId);
    //减少购买数量
    void reduceBuyCount(Integer cartItemId);

//    //根据id显示用户购物车列表
//    List<CartItem> getCartItemByUserBeanId(@Param("id") Integer id);

    //根据用户id获取购物车项
    List<CartItem> getListByUserID(@Param("id") Integer id);

    //删除特定的购物车数据
    void deleteCartItem(CartItem cartItem);
}
