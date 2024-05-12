package com.tribune.j2ee.bookstore.model;


import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author implements Serializable {

    private long id;
    private String name;
    private List<Book> books;
}
