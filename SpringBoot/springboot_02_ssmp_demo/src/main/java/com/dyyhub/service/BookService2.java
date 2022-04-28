package com.dyyhub.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyyhub.pojo.Book;

import java.util.List;

public interface BookService2 {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage,int pageSize);
}
