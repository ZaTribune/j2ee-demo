package com.tribune.j2ee.bookstore.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebUser {
    private String name;
    private String password;
}
