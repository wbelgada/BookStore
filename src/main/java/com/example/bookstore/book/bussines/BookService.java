package com.example.bookstore.book.bussines;

import com.example.bookstore.book.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewbook(Book book) {}
}