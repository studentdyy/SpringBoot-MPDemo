package com.dyyhub.service;

import com.dyyhub.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MPBookServiceImplTest {

    @Autowired
    private IBookService bookService;

    @Test
    void insert() {
        Book book = new Book();
        book.setType("自然科学");
        book.setName("大自然未解之谜");
        book.setDescription("学生课外阅读丛书");
        System.out.println(bookService.saveBook(book));
    }

    @Test
    void selectById() {
        System.out.println(bookService.getById(4));
    }
}
