package com.example.bookmanager.domain;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Entity
@Table(name = "REVIEWS")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(nullable = false)
    String isbn;

    @Lob
    String body;

    Integer grade;

    @Version
    Integer version;

    @ManyToOne
    Book book;
}
