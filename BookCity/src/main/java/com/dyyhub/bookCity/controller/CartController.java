package com.dyyhub.bookCity.controller;


import com.dyyhub.bookCity.pojo.Book;
import com.dyyhub.bookCity.pojo.Cart;
import com.dyyhub.bookCity.pojo.CartItem;
import com.dyyhub.bookCity.pojo.User;
import com.dyyhub.bookCity.service.BookService;
import com.dyyhub.bookCity.service.CartItemService;
import com.dyyhub.bookCity.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    @Qualifier("bookService")
    BookService bookService;

    @Autowired
    @Qualifier("cartService")
    CartService cartService;

    @Autowired
    @Qualifier("cartItemService")
    CartItemService cartItemService;


    @RequestMapping("/add")
    public String add(Integer bookId, HttpSession session){
        //将当前图书加入到购物车中
        //逻辑1，如果当前用户的购物车已经存在了 那么该书的数量加+1
        //2，否则，在当前的用户的购物车新增一个cartItem，数量是1
//        Book book = bookService.getBookById(bookId);
        User user  = (User) session.getAttribute("currUser");
        CartItem cartItem = new CartItem(bookId,1,user.getId());
        Cart cart = user.getCart();

        cartItemService.addOrUpdateCartItem(cartItem,cart);

        //更新购物车
        cartService.updateCart(user);


        return "redirect:/cart/list";
//        cartItemService.addOrUpdateCartItem();
    }

    @RequestMapping("/list")
    public String getCartItemList(HttpServletRequest request,HttpSession session){
        User user = (User) session.getAttribute("currUser");
        List<CartItem> cartItemList = cartService.showCartItemListByUserID(user.getId());
        request.setAttribute("cartItemList",cartItemList);
        return "cart/cart";
    }

    @RequestMapping("/updateBuyCount")
    public String updateBuyCount(HttpSession session,Integer cartItemId,String operate){
        User user = (User) session.getAttribute("currUser");
        cartItemService.updateBuyCount(cartItemId,operate);
        cartService.updateCart(user);
        return "forward:/cart/list";
    }
}
