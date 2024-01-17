package org.deomugabe.bookapplication.service;

import org.deomugabe.bookapplication.dto.request.CreateBook;
import org.deomugabe.bookapplication.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> findAll();

    BookResponse findById(Long id);

    void deleteById(Long id);

    BookResponse createBook(CreateBook createBook);

    BookResponse updateBookById(Long id, CreateBook createBook);
}
