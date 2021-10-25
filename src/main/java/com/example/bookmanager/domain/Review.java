package com.example.bookmanager.domain;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, doNotUseGetters = true)
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Entity
@Table(name = "REVIEWS")
public class Review extends BaseEntity{

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String body;

    @Min(0)
    @Max(10)
    private Integer grade;

    @ManyToOne
    private Book book;
}
