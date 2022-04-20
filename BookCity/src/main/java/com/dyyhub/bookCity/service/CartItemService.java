package com.dyyhub.bookCity.service;


import com.dyyhub.bookCity.pojo.Cart;
import com.dyyhub.bookCity.pojo.CartItem;

import java.util.List;

public interface CartItemService {

    void add(CartItem cartItem);

    void update(CartItem cartItem);

    void addOrUpdateCartItem(CartItem cartItem, Cart cart);

    List<CartItem> getListByUserID(Integer userId);

}
