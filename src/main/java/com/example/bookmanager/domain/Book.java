package com.example.bookmanager.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(unique = true, nullable = false)
    String isbn;

    @Column(nullable = false)
    String title;
    String description;
    String author;

    @Version
    Integer version;

    @ToString.Exclude
    @OneToMany(mappedBy = "book")
    @JsonBackReference
    List<Review> reviews;
}
