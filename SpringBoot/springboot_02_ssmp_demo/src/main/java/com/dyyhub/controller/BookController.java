package com.dyyhub.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyyhub.controller.utils.Result;
import com.dyyhub.pojo.Book;
import com.dyyhub.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public Result getAll(){
        return new Result(true,bookService.list());
    }

    @PostMapping
    public Result save(@RequestBody Book book){
//        if(book.getName().equals("123")) throw new NullPointerException();
        boolean flag = bookService.saveBook(book);
        return new Result(flag,flag ? "添加成功(●'◡'●)" : "添加失败/(ㄒoㄒ)/~~");
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        boolean flag = bookService.updateBook(book);
        return new Result(flag,flag ? "修改成功(*^_^*)" : "修改失败（＞人＜；）");
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = bookService.deleteBook(id);
        return new Result(flag,flag ? "删除成功o(*￣▽￣*)o" : "删除失败(～￣▽￣)～");
    }

    //http:localhost/books/1
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true,bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大的页码值作为当前页码值。
//        //如果数据量特别大，那么这个解决方案是有bug的。
//        if(currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new Result(true,page);
//    }
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){

//        System.out.println(name);
//        System.out.println(book);

        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大的页码值作为当前页码值。
        //如果数据量特别大，那么这个解决方案是有bug的。
        if(currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new Result(true,page);
    }

}
