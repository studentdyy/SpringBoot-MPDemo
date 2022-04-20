package com.dyyhub.bookCity.mapper;

import com.dyyhub.bookCity.pojo.test;

import java.util.List;

public interface testMapper {
    List<test> selectAll();
    void insert(test test);
    void deleteById(Integer id);
    void updateTest(test test);
}
