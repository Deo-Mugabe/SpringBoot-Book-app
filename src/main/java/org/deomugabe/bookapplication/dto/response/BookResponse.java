package org.deomugabe.bookapplication.dto.response;

import lombok.Data;
import org.deomugabe.bookapplication.domain.Book;

@Data
public class BookResponse {
    private Long id;
    private String isbn;
    private String title;

    public static BookResponse from(Book book){
        BookResponse bookResponse = new BookResponse();
        bookResponse.id=book.getId();
        bookResponse.isbn=book.getIsbn();
        bookResponse.title=book.getTitle();

        return bookResponse;
    }
}
