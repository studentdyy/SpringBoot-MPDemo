package com.dyyhub.bookCity.pojo;



import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

//每个用户的有个购物车
public class Cart {


    //购物车中购物车项的集合，这个Map集合中的key对应的是每个Book的id
    private Map<Integer,CartItem> cartItemMap;
    //购物车总价
    private Double totalMoney;
    //购物车的书本种类数量
    private Integer totalCartNum;
    //购物车所有商品数量
    private Integer totalBookCount;

    BigDecimal bigDecimalPrice = null;
    BigDecimal bigDecimalBuyCount = null;
    BigDecimal bigDecimalZJ = null;


    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        if(cartItemMap != null && cartItemMap.size() > 0){
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for(Map.Entry<Integer, CartItem> cartItemEntry : entries){
                CartItem cartItem = cartItemEntry.getValue();
                bigDecimalPrice = new BigDecimal(""+cartItem.getBook().getPrice());
                bigDecimalBuyCount = new BigDecimal(""+cartItem.getBuyCount());
                bigDecimalZJ = bigDecimalPrice.multiply(bigDecimalBuyCount);
                totalMoney = totalMoney + bigDecimalZJ.doubleValue();
            }
        }
        return totalMoney;
    }


    public Integer getTotalCartNum() {
        totalCartNum = 0;
        if(cartItemMap != null && cartItemMap.size() > 0){
            totalCartNum = cartItemMap.size();
        }
        return totalCartNum;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if(cartItemMap != null && cartItemMap.size() > 0){
            for(CartItem cartItem : cartItemMap.values()){
                totalBookCount = totalBookCount + cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }

}
