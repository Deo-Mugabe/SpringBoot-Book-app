package org.deomugabe.bookapplication.repository;

import org.deomugabe.bookapplication.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
