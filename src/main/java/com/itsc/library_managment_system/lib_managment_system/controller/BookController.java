package com.itsc.library_managment_system.lib_managment_system.controller;

import org.springframework.web.bind.annotation.RestController;

import com.itsc.library_managment_system.lib_managment_system.model.Book;
import com.itsc.library_managment_system.lib_managment_system.service.BookService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public List<Book> getAllBooks() {
    return bookService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Book> getBookById(@PathVariable Long id) {
    return bookService.findById(id);
  }

  @PostMapping
  public Book addBook(@RequestBody Book book) {
    return bookService.save(book);
  }

  @PutMapping("/{id}")
  public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
    book.setId(id);
    return bookService.save(book);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Long id) {
    bookService.deleteById(id);
  }
}