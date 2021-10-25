package com.example.bookmanager.config;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.Review;
import com.example.bookmanager.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final GenericService<Book> bookService;
    private final GenericService<Review> reviewService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Book book1 = Book.builder()
                .isbn("978-1788299459")
                .title("Spring 5 Design Patterns")
                .description("Learn various design patterns and best practices in Spring 5 and use them to solve common design problems")
                .author("Dinesh Rajput")
                .build();
        Book book2 = Book.builder()
                .isbn("978-1617294549")
                .title("Microservices Patterns: With examples in Java")
                .description("44 reusable patterns to develop and deploy reliable production-quality microservices-based applications, with worked examples in Java")
                .author("Chris Richardson")
                .build();
        Book book3 = Book.builder()
                .isbn("978-0134685991")
                .title("Effective Java")
                .description("Joshua Bloch covers some highlights from the third edition of “Effective Java”, concentrating on streams and lambdas. The recently released edition of Effective Java contains one new chapter, fourteen new items, and numerous changes to existing items.")
                .author("Joshua Bloch")
                .build();
        Stream.of(book1, book2, book3).forEach(bookService::save);

        Review review1 = Review.builder()
                .isbn("978-0134685991")
                .body("This is an amazing book which contains tons of good practical advice for programmers, but more importantly explains the \"why\" behind various things you've always heard. " +
                        "There are things I feel I understand after reading this book which I previously only \"knew\" on the level of a teacher saying \"take my word for it." +
                        "The book also lets you seen behind the scenes of Java programming in a way you possibly never have before, because Joshua Block is one of the developers behind Java itself," +
                        " and all the main Oracle supported libraries. As such he can tell you that certain implementations in the standard Java libraries actually violate various best practices " +
                        "(either by accident or because those best practices hadn't emerged at the time of development). " +
                        "Almost always he will note that the problem cannot be fixed due to backward compatibility and has consequences to this day. Very few textbooks actually let you see inside details like this." +
                        "No other book I've read gives this kind of insight. And it's not even a hard read. ")
                .grade(5)
                .book(book3)
                .build();

        reviewService.save(review1);
    }
}
