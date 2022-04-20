package com.dyyhub.bookCity.service;

import com.dyyhub.bookCity.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookList();
    Book getBookById(Integer bookId);
}
