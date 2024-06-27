package com.itsc.library_managment_system.lib_managment_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsc.library_managment_system.lib_managment_system.model.Book;
import com.itsc.library_managment_system.lib_managment_system.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public Optional<Book> findById(Long id) {
    return bookRepository.findById(id);
  }

  public Book save(Book book) {
    return bookRepository.save(book);
  }

  public void deleteById(Long id) {
    bookRepository.deleteById(id);
  }
}
