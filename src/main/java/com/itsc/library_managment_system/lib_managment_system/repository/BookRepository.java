package com.itsc.library_managment_system.lib_managment_system.repository;

import com.itsc.library_managment_system.lib_managment_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}
