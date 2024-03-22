package com.rs.bookservice.command.event;

import com.rs.bookservice.command.data.Book;
import com.rs.bookservice.command.data.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //
public class BookEventHandler {
    @Autowired
    private BookRepository bookRepository;

    @EventHandler
    public void on(BookCreatedEvent event) {
//        khoi tao Book Entity
        Book book = new Book();
        BeanUtils.copyProperties(event, book);
        bookRepository.save(book); // save in database
    }

    @EventHandler
    public void on(BookUpdatedEvent event) {
        Book book = bookRepository.getById(event.getBookId());
        book.setName(event.getName());
        book.setAuthor(event.getAuthor());
        book.setReady(event.getReady());
        bookRepository.save(book);
    }

    @EventHandler
    public void on(BookDeletedEvent event) {
        bookRepository.deleteById(event.getBookId());
    }
}
