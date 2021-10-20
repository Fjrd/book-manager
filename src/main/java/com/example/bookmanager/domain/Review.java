package com.example.bookmanager.domain;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @Column(nullable = false)
    String body;

    @Min(0)
    @Max(10)
    Integer grade;

    @Version
    Integer version;

    @ManyToOne
    Book book;
}
