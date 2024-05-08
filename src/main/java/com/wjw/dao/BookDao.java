package com.wjw.dao;

import com.wjw.po.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface BookDao {
    // 增加一个图书
    @Insert("insert tbl_book(type,name,description) values (#{type},#{name},#{description})")
    Boolean saveBook(Book book);

    // 根据id删除一个图书
    @Delete("delete from tbl_book where id = #{id}")
    Boolean deleteById(Integer id);

    // 修改一个图书信息
    @Update("update tbl_book set type=#{type},name=#{name},description=#{description} where id = #{id}")
    Boolean updateBookInfo(Book book);

    // 查询一个图书
    @Select("select id,type,name,description from tbl_book where id = #{id}")
    Book findById(Integer id);

    // 查询全部图书
    @Select("select id,type,name,description from tbl_book")
    List<Book> findAll();

    // 通过图书名称模糊查询
    @Select("select id, type,name,description from tbl_book where name like concat('%',#{name}, '%')")
    List<Book> getBooksByName(String name);
}
