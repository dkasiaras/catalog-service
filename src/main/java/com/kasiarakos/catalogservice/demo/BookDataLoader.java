package com.kasiarakos.catalogservice.demo;

import com.kasiarakos.catalogservice.domain.Book;
import com.kasiarakos.catalogservice.domain.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Profile("testdata")
@AllArgsConstructor
public class BookDataLoader implements ApplicationListener<ApplicationReadyEvent> {

  private final BookRepository bookRepository;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    log.info("############### Initializing Application Data ################");
    bookRepository.deleteAll();
    var book1 = Book.of("1234567891", "Harry Potter and the Philosopher's Stone", "J. K. Rowling", 9.90, "publisher");
    var book2 = Book.of("1234567892", "Harry Potter and the Chamber of Secrets", "J. K. Rowling", 12.90, "publisher");
    bookRepository.saveAll(List.of(book1, book2));
    log.info("############### Initialized Application Data ################");
  }
}