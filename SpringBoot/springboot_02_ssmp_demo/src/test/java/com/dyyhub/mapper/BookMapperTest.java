package com.dyyhub.mapper;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dyyhub.mapper.BookMapper;
import com.dyyhub.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void selectById() {
        System.out.println(bookMapper.selectById(1));
    }

    @Test
    void insert() {
        Book book = new Book();
        book.setType("计算机理论");
        book.setName("spring核心 第5版");
        book.setDescription("spring入门经典教程，深入理解spring原理技术内幕");
        System.out.println(bookMapper.insert(book));
    }
    @Test
    void update() {
        Book book = new Book();
        book.setId(4);
        book.setType("科幻");
        book.setName("三体");
        book.setDescription("我最喜欢看的一本科幻小说！");
        System.out.println(bookMapper.updateById(book));
    }

    @Test
    void selectAll() {
        List<Book> books = bookMapper.selectList(null);
        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1,3);
        bookMapper.selectPage(page,null);
    }

    @Test
    void likeSelect() {
        QueryWrapper<Book> qw1 = new QueryWrapper<>();
        qw1.like("name","三");
        bookMapper.selectList(qw1);
    }

    @Test
    void likeSelect2() {
        String name = null;
        LambdaQueryWrapper<Book> qw2 = new LambdaQueryWrapper<>();

        //if(name != null) qw2.like(Book::getName,"三");
        qw2.like(name != null,Book::getName,"三");

        bookMapper.selectList(qw2);
    }

}
