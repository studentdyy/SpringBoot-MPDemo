package com.dyyhub.bookCity.mapper;

import com.dyyhub.bookCity.pojo.test;

import java.util.List;

public interface testMapper {
    public List<test> selectAll();
    public void insert(test test);
    public void deleteById(Integer id);
    public void updateTest(test test);
}
