package com.itsc.library_managment_system.lib_managment_system.model;

public class Book {
  private Long id;
  private String title;
  private String author;
  private String isbn;

  // create constructor
  public Book(Long id, String title, String author, String isbn) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.isbn = isbn;
  }

  // constructor without id
  public Book(String title, String author, String isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
  }

  // getter and setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
