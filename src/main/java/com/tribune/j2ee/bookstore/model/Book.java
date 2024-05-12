package com.tribune.j2ee.bookstore.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements Serializable {

    private long id;
    private String name;
    private long author;
}
