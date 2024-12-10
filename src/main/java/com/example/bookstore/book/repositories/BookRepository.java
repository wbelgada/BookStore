package com.example.bookstore.book.repositories;

import com.example.bookstore.book.bussines.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.isbn = ?1")
    Optional<Book> findByIsbn(String isbn);

    @Query("SELECT EXISTS ( SELECT 1 FROM Book WHERE isbn = ?1)")
    boolean existsByIsbn(String isbn);

    @Modifying
    @Query("DELETE FROM Book WHERE isbn = '?1'")
    void deleteByIsbn(String isbn);
}
