package com.datasoftlibrary.services;

import com.datasoftlibrary.models.Books;
import com.datasoftlibrary.repositories.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> getBooksByGenre(String name) {
        List<Books> books = new ArrayList<>();
        booksRepository.findAll().forEach(books::add);

        List<Books> filteredBooks = new ArrayList<>();
        for (Books book : books) {
            if (book.getGenre().getName().equals(name)) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    public Optional<Books> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    public void updateBook(Books book) {
        booksRepository.save(book);
    }
}
