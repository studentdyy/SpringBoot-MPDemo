package com.dyyhub.bookCity.mapper;

import com.dyyhub.bookCity.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    List<Book> getBookList();

    Book getBookById(@Param("id") Integer BookId);
}
