package com.dyyhub;

import com.dyyhub.dao.userDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01QuickstartApplicationTests {

    @Autowired
    private userDao userDao;

    @Test
    void contextLoads() {
        System.out.println(userDao.selectById(1));

    }

}
