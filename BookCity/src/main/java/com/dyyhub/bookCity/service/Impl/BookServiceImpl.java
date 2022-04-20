package com.dyyhub.bookCity.service.Impl;

import com.dyyhub.bookCity.mapper.BookMapper;
import com.dyyhub.bookCity.pojo.Book;
import com.dyyhub.bookCity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> getBookList() {
        return bookMapper.getBookList();
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookMapper.getBookById(bookId);
    }
}
