package com.wjw.controller;

import com.wjw.exception.BusinessException;
import com.wjw.po.Book;
import com.wjw.service.BookService;
import com.wjw.vo.Code;
import com.wjw.vo.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result saveBook(@RequestBody Book book) {
        Boolean flag = bookService.saveBook(book);
        // code msg data
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = flag ? "插入成功" : "插入失败";
        return new Result(code, msg, flag);
    }

    // 根据id删除一个图书
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        Boolean flag = bookService.deleteById(id);
        Integer code = flag ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = flag ? "删除成功" : "删除失败";
        return new Result(code, msg, flag);
    }

    // 修改一个图书信息
    @PutMapping
    public Result updateBookInfo(@RequestBody Book book) {
        Boolean flag = bookService.updateBookInfo(book);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String msg = flag ? "更新成功" : "更新失败";
        return new Result(code, msg, flag);
    }

    // 查询一个图书
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        Book book = bookService.findById(id);
        Integer code = null;
        String msg = null;
        if (book != null) {
            code = Code.SELECT_OK;
            msg = "查询成功";
        } else {
            code = Code.SELECT_ERR;
            msg = "查询失败";
        }
        return new Result(code, msg, book);

    }

    // 查询全部图书
    @GetMapping
    public Result findAll() {
        List<Book> bookList = bookService.findAll();
        Integer code = bookList != null ? Code.SELECT_OK : Code.SELECT_ERR;
        String msg = bookList != null ? "查询成功" : "查询失败";
        return new Result(code, msg, bookList);
    }
    // 通过图书名称模糊查询 如果通过GET 传过来中文需要处理编码问题
    @PostMapping("/search")
    public Result getBooksByName(@RequestBody Book book) {
        String name = book.getName();
        List<Book> bookList = bookService.getBooksByName(name);
        Integer code = bookList != null ? Code.SELECT_OK : Code.SELECT_ERR;
        String msg = bookList != null ? "查询成功" : "查询失败";
        return new Result(code, msg, bookList);
    }
}
