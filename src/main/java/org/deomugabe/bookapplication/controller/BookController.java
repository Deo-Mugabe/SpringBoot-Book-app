package org.deomugabe.bookapplication.controller;


import org.deomugabe.bookapplication.dto.request.CreateBook;
import org.deomugabe.bookapplication.dto.response.BookResponse;
import org.deomugabe.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<?> getAllBooks(){
        List<BookResponse> bookResponses = bookService.findAll();
        return new ResponseEntity<>(bookResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){
        BookResponse bookResponse = bookService.findById(id);
        return new ResponseEntity<>(bookResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody CreateBook createBook){
        BookResponse bookResponse = bookService.createBook(createBook);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable Long id, @RequestBody CreateBook createBook){
        BookResponse bookResponse = bookService.updateBookById(id, createBook);
        return new ResponseEntity<>(bookResponse, HttpStatus.ACCEPTED);
    }
}
