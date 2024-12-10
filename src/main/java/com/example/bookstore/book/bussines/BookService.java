package com.example.bookstore.book.bussines;

import com.example.bookstore.book.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public void addNewbook(Book book) {

        Optional<Book> bookByIsbn = bookRepository.findByIsbn(book.getIsbn());

        if (bookByIsbn.isPresent()) {
            throw new IllegalStateException("Book with ISBN " + book.getIsbn() + " already exists");
        }
        bookRepository.save(book);
    }

    public void deleteBook(String isbn) {

        boolean exists = bookRepository.existsByIsbn(isbn);

        if (!exists) {
            System.out.println("Book with ISBN " + isbn + " does not exist");
            throw new IllegalStateException("Book with ISBN " + isbn + " does not exist");
        }
        bookRepository.deleteByIsbn(isbn);
    }

}