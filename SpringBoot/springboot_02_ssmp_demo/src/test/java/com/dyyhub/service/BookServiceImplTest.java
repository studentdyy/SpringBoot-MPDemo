package com.dyyhub.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyyhub.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceImplTest {
    @Autowired
    private BookService2 bookService2;

    @Test
    void selectById() {
        System.out.println(bookService2.getById(1));
    }

    @Test
    void getPage(){
        IPage<Book> page = bookService2.getPage(2, 2);
        System.out.println(page);
    }

}
