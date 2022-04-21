package com.dyyhub.bookCity.pojo;

public class OrderItem {
    private Integer id;
    private Integer book;
    private Integer buyCount;
    private Integer orderBean;

    private OrderBean orderBeanObject;  // M:1
    private Book bookObject;          //M:1

    public OrderItem() {
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", book=" + book +
                ", buyCount=" + buyCount +
                ", orderBean=" + orderBean +
                ", orderBeanObject=" + orderBeanObject +
                ", bookObject=" + bookObject +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(Integer orderBean) {
        this.orderBean = orderBean;
    }

    public OrderBean getOrderBeanObject() {
        return orderBeanObject;
    }

    public void setOrderBeanObject(OrderBean orderBeanObject) {
        this.orderBeanObject = orderBeanObject;
    }

    public Book getBookObject() {
        return bookObject;
    }

    public void setBookObject(Book bookObject) {
        this.bookObject = bookObject;
    }
}
