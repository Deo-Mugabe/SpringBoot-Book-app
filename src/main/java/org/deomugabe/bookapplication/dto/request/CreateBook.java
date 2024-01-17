package org.deomugabe.bookapplication.dto.request;

import lombok.Data;

@Data
public class CreateBook {
    private Long id;
    private String isbn;
    private String title;
}
