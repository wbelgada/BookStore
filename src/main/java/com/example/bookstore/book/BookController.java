package com.example.bookstore.book;

import com.example.bookstore.book.bussines.Book;
import com.example.bookstore.book.bussines.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void registerBook(@RequestBody Book book) {
        bookService.addNewbook(book);
    }
}
