package com.example.controller;

import com.example.BookNotFoundException;
import com.example.pojo.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping(name = "/getAllBook")
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @GetMapping(name = "/getBook", value = "{bookId}")
    public Book getBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @PostMapping(name = "/saveBook")
    public Book saveBook(@RequestBody Book bookRecord) {
        return bookRepository.save(bookRecord);
    }

    @PutMapping(name = "/saveBook")
    public Book updateBook(@RequestBody Book bookRecord) throws BookNotFoundException {
        if (bookRecord == null || bookRecord.getBookId() == null)
            throw new BookNotFoundException("Bookid should not be null");
        Optional<Book> book = bookRepository.findById(bookRecord.getBookId());
        if (!book.isPresent())
            throw new BookNotFoundException("Book is not available");
        Book existBook = book.get();
        existBook.setName(bookRecord.getName());
        existBook.setSummary(bookRecord.getSummary());
        existBook.setRating(bookRecord.getRating());
        return bookRepository.save(existBook);
    }

}
