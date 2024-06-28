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

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Book getBookById(Long id) {
    Optional<Book> optionalBook = bookRepository.findById(id);
    return optionalBook.orElse(null);
  }

  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }

  public Book updateBook(Long id, Book bookDetails) {
    Book book = getBookById(id);
    if (book != null) {
      book.setTitle(bookDetails.getTitle());
      book.setAuthor(bookDetails.getAuthor());
      book.setIsbn(bookDetails.getIsbn());
      return bookRepository.save(book);
    }
    return null;
  }

  public void deleteBook(Long id) {
    bookRepository.deleteById(id);
  }
}
