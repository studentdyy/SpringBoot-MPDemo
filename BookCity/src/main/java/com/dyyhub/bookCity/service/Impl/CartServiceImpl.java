package com.dyyhub.bookCity.service.Impl;

import com.dyyhub.bookCity.mapper.BookMapper;
import com.dyyhub.bookCity.mapper.CartItemMapper;
import com.dyyhub.bookCity.pojo.Book;
import com.dyyhub.bookCity.pojo.Cart;
import com.dyyhub.bookCity.pojo.CartItem;
import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cartService")
public class CartServiceImpl implements CartService {

    @Autowired
    CartItemMapper cartItemMapper;
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<CartItem> showCartItemListByUserID(Integer userId) {
        List<CartItem> cartItemList = cartItemMapper.getListByUserID(userId);
        for(CartItem cartItem : cartItemList){
            Book Book = bookMapper.getBookById(cartItem.getBookID());
            cartItem.setBook(Book);
        }
        return cartItemList;
    }

    @Override
    public Cart getCartByUser(User user) {
        List<CartItem> cartItemList = showCartItemListByUserID(user.getId());
        Map<Integer,CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList){
            cartItemMap.put(cartItem.getBookID(),cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;
    }

    @Override
    public void updateCart(User user) {
        Map<Integer,CartItem> cartItemMap = new HashMap<>();
        List<CartItem> cartItemList = showCartItemListByUserID(user.getId());
        for (CartItem cartItem : cartItemList){
            cartItemMap.put(cartItem.getBookID(),cartItem);
        }
        user.getCart().setCartItemMap(cartItemMap);
    }
}
