package com.example.bookstore.book;


import com.example.bookstore.book.bussines.Book;
import com.example.bookstore.book.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner runner(BookRepository bookRepository) {
        return args -> {
            Book firstBook = new Book(
                    "La langue des choses cachées",
                    "Cécile Coulon",
                    "978-3-16-148410-0",
                    "ebay",
                    601,
                    "Roman");

            Book secondBook = new Book(
                    "La guerre des étoiles",
                    "Wassim Belgada",
                    "999-9-99-999999-9",
                    "marketplace",
                    456,
                    "Policier");

            bookRepository.saveAll(List.of(firstBook,secondBook));
        };
    };
}
