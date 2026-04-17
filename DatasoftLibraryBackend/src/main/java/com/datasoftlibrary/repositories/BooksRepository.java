package com.datasoftlibrary.repositories;

import com.datasoftlibrary.models.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long> {
}
