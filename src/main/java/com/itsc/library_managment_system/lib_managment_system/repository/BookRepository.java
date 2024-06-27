package com.itsc.library_managment_system.lib_managment_system.repository;

import java.util.List;
import java.util.Optional;

import com.itsc.library_managment_system.lib_managment_system.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findAll();

  Optional<Book> findById(Long id);

  Book save(Book book);

  void deleteById(Long id);
}
