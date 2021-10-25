package com.example.bookmanager.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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
public class Book extends BaseEntity {

    private String isbn;
    private String title;
    private String description;
    private String author;

    @ToString.Exclude
    @OneToMany(mappedBy = "book")
    @JsonBackReference
    private List<Review> reviews;
}
