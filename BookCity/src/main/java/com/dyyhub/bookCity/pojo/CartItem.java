package com.dyyhub.bookCity.pojo;


public class CartItem {
    private Integer id;
    private Integer bookID;
    private Integer buyCount;
    private Integer userID;

    private Book book;
    private User user;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", bookID=" + bookID +
                ", buyCount=" + buyCount +
                ", userID=" + userID +
                ", book=" + book +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CartItem() {
    }

    public CartItem(Integer id, Integer bookID, Integer buyCount, Integer userID) {
        this.id = id;
        this.bookID = bookID;
        this.buyCount = buyCount;
        this.userID = userID;
    }

    public CartItem(Integer bookID, Integer buyCount, Integer userID) {
        this.bookID = bookID;
        this.buyCount = buyCount;
        this.userID = userID;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }


}
