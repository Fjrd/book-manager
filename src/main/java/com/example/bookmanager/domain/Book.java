package com.example.bookmanager.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

import static lombok.EqualsAndHashCode.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@ToString(doNotUseGetters = true)
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, doNotUseGetters = true)
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Include
    private UUID id;

    private String isbn;
    private String title;
    private String description;
    private String author;

    @Version
    private Integer version;

    @ToString.Exclude
    @OneToMany(mappedBy = "book")
    @JsonBackReference
    private List<Review> reviews;
}
