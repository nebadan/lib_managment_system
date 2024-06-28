package com.itsc.library_managment_system.lib_managment_system.controller;

import com.itsc.library_managment_system.lib_managment_system.model.Book;
import com.itsc.library_managment_system.lib_managment_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping
  public List<Book> getAllBooks() {
    System.out.println("getAll books called");
    return bookService.getAllBooks();
  }

  @GetMapping("/{id}")
  public Book getBookById(@PathVariable Long id) {
    return bookService.getBookById(id);
  }

  @PostMapping

  public Book createBook(@RequestBody Book book) {
    System.out.println("create book called");
    return bookService.saveBook(book);
  }

  @PutMapping("/{id}")
  public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
    return bookService.updateBook(id, bookDetails);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
  }
}
