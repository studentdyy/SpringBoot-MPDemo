package com.dyyhub.bookCity.service.Impl;

import com.dyyhub.bookCity.mapper.CartItemMapper;
import com.dyyhub.bookCity.pojo.Cart;
import com.dyyhub.bookCity.pojo.CartItem;
import com.dyyhub.bookCity.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("cartItemService")
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemMapper cartItemMapper;


    @Override
    public void add(CartItem cartItem) {
        cartItemMapper.add(cartItem);
    }

    @Override
    public List<CartItem> getListByUserID(Integer userId) {
        return cartItemMapper.getListByUserID(userId);
    }

    @Override
    public void update(CartItem cartItem) {
        cartItemMapper.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        //判断当前用户的这本书是否有对应的cartItem
        //有 则update，无 则add
        if(cart.getCartItemMap().containsKey(cartItem.getBookID())){
          cartItemMapper.updateCartItem(cartItem);
        }
        else {
            cartItemMapper.add(cartItem);
        }

//        if(cart != null){
//            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
//            if(cartItemMap == null){
//                cartItemMap = new HashMap<>();
//            }
//
//            if(cartItemMap.containsKey(cartItem.getBookID())){
//                CartItem cartItemTemp = cartItemMap.get(cartItem.getBookID());
//                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount()+1);
//                cartItemMapper.updateCartItem(cartItemTemp);
//            }
//        }
    }
}
