package com.wjw.service;

import com.wjw.po.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BookService {
    // 增加一个图书
    Boolean saveBook(Book book);

    // 根据id删除一个图书
    Boolean deleteById(Integer id);

    // 修改一个图书信息
    Boolean updateBookInfo(Book book);

    // 查询一个图书
    Book findById(Integer id);

    // 查询全部图书
    List<Book> findAll();
}
