package org.deomugabe.bookapplication.service.Impl;

import org.deomugabe.bookapplication.domain.Book;
import org.deomugabe.bookapplication.dto.request.CreateBook;
import org.deomugabe.bookapplication.dto.response.BookResponse;
import org.deomugabe.bookapplication.exceptions.BookNotFoundException;
import org.deomugabe.bookapplication.repository.BookRepository;
import org.deomugabe.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookResponse> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponse::from)
                .toList();

    }

    @Override
    public BookResponse findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(String.format("Book of id %s not Found", id)));

        return BookResponse.from(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookResponse createBook(CreateBook createBook) {
        Book book = new Book();
        book.setTitle(createBook.getTitle());
        book.setIsbn(createBook.getIsbn());
        bookRepository.save(book);
        return BookResponse.from(book);
    }

    @Override
    public BookResponse updateBookById(Long id, CreateBook createBook) {

        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            book.setIsbn(createBook.getIsbn());
            book.setTitle(createBook.getTitle());
            bookRepository.save(book);
            return BookResponse.from(book);
        }
        else {
            throw new BookNotFoundException("Book not Found");
        }


    }
}
