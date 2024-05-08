package com.wjw.controller;

import com.wjw.config.SpringConfig;
import com.wjw.po.Book;
import com.wjw.vo.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookControllerTest {
    @Autowired
    private BookController bookController;
    @Test
    public void testFindAll(){
        Result bookList = bookController.findAll();
        System.out.println(bookList);
    }
}
