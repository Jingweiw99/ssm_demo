package com.wjw.service.impl;

import com.wjw.dao.BookDao;
import com.wjw.po.Book;
import com.wjw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Boolean saveBook(Book book) {
        return bookDao.saveBook(book);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return bookDao.deleteById(id);
    }

    @Override
    public Boolean updateBookInfo(Book book) {
        return bookDao.updateBookInfo(book);
    }

    @Override
    public Book findById(Integer id) {
        Book book = bookDao.findById(id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return bookDao.getBooksByName(name);
    }
}
