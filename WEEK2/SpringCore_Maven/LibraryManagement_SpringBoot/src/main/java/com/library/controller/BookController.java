package com.library.controller;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    // Add Book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    // Get All Books
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // Get Book By Id
    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable int id) {
        return repository.findById(id);
    }

    // Update Book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        return repository.save(book);
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        repository.deleteById(id);
        return "Book Deleted Successfully";
    }
}