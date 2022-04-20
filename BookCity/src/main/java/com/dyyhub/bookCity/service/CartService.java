package com.dyyhub.bookCity.service;

import com.dyyhub.bookCity.pojo.Cart;
import com.dyyhub.bookCity.pojo.CartItem;
import com.dyyhub.bookCity.pojo.User;

import java.util.List;

public interface CartService {

    List<CartItem> showCartItemListByUserID(Integer userId);

    Cart getCartByUser(User user);

}
