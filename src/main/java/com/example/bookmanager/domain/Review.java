package com.example.bookmanager.domain;

import lombok.*;
import lombok.EqualsAndHashCode.Include;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Include
    private UUID id;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String body;

    @Min(0)
    @Max(10)
    private Integer grade;

    @Version
    private Integer version;

    @ManyToOne
    private Book book;
}
