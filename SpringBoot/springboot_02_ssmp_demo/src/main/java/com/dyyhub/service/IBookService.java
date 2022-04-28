package com.dyyhub.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dyyhub.pojo.Book;

public interface IBookService extends IService<Book> {

    boolean saveBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Integer id);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
    IPage<Book> getPage(int currentPage, int pageSize);
}
