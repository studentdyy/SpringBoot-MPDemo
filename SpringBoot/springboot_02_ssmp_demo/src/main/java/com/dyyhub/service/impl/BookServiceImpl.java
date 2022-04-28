package com.dyyhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyyhub.mapper.BookMapper;
import com.dyyhub.pojo.Book;
import com.dyyhub.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public boolean saveBook(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public boolean updateBook(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public boolean deleteBook(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        return bookMapper.selectPage(page,null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        IPage page = new Page(currentPage,pageSize);
        return bookMapper.selectPage(page,lqw);
    }


}
