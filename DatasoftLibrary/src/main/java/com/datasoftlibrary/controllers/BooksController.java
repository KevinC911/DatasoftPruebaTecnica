package com.datasoftlibrary.controllers;

import com.datasoftlibrary.models.Books;
import com.datasoftlibrary.models.DTOs.CreateBookDTO;
import com.datasoftlibrary.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/byGenre")
    public ResponseEntity<?> getBooksByGenre(@RequestParam String genre) {
        List<Books> books = booksService.getBooksByGenre(genre);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(books);
    }

    @GetMapping("/byId")
    public ResponseEntity<?> getBookById(@RequestParam Long id) {
        Optional<Books> book = booksService.getBookById(id);
        if (book.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(book.get());
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateBook(@RequestBody CreateBookDTO bookInfo) {
        Books updatedBook = Books.builder()
                .id(bookInfo.getId())
                .name(bookInfo.getName())
                .summary(bookInfo.getSummary())
                .price(bookInfo.getPrice())
                .state(bookInfo.getState())
                .genre(bookInfo.getGenre())
                .user(bookInfo.getUser())
                .build();

        booksService.updateBook(updatedBook);
        return ResponseEntity.ok(updatedBook);

    }
}
