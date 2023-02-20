package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
@Slf4j
public class BookDataLoader {

    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void loadBookTestData() {
        var book1 = new Book("1234567891", "Northern Lights",
                "Lyra Silverstar", 9.90);
        var book2 = new Book("1234567892", "Polar Journey",
                "Iorek Polarson", 12.90);
        bookRepository.save(book1);
        bookRepository.save(book2);
        log.info("book repository loaded with test data.");
    }

}
