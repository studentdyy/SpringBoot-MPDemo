package com.dyyhub.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyyhub.pojo.Book;
import com.dyyhub.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    @PostMapping
    public boolean save(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PutMapping
    public boolean update(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }

    //http:localhost/books/1
    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return bookService.getPage(currentPage,pageSize, null);
    }

}
