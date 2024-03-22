package com.rs.bookservice.command.aggregate;

import com.rs.bookservice.command.command.CreateBookCommand;
import com.rs.bookservice.command.command.DeleteBookCommand;
import com.rs.bookservice.command.command.UpdateBookCommand;
import com.rs.bookservice.command.event.BookCreatedEvent;
import com.rs.bookservice.command.event.BookDeletedEvent;
import com.rs.bookservice.command.event.BookUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class BookAggregate {
    @AggregateIdentifier
    private String bookId;
    private String name;
    private String author;
    private Boolean isReady;

    public BookAggregate() {

    }

    @CommandHandler
    public  BookAggregate(CreateBookCommand createBookCommand) {
        BookCreatedEvent bookCreatedEvent
                = new BookCreatedEvent();
//        copy all properies from createBookCommand to bookCreatedEvent
        BeanUtils.copyProperties(createBookCommand, bookCreatedEvent);
//        phát đi event bookCreatedEvent
        AggregateLifecycle.apply(bookCreatedEvent);
    }
    @EventSourcingHandler
    public void on(BookCreatedEvent event) {
        this.bookId = event.getBookId();
        this.author = event.getAuthor();
        this.name = event.getName();
        this.isReady = event.getReady();
    }

    @CommandHandler
    public void handle(UpdateBookCommand updateBookCommand) {
        BookUpdatedEvent bookUpdatedEvent
                = new BookUpdatedEvent();
        BeanUtils.copyProperties(updateBookCommand, bookUpdatedEvent);
        AggregateLifecycle.apply(bookUpdatedEvent);
    }
    @EventSourcingHandler
    public void on(BookUpdatedEvent event) {
        this.bookId = event.getBookId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.isReady = event.getReady();
    }

    @CommandHandler
    public void handle(DeleteBookCommand deleteBookCommand) {
        BookDeletedEvent bookDeletedEvent =
                new BookDeletedEvent();
        BeanUtils.copyProperties(deleteBookCommand, bookDeletedEvent);
        AggregateLifecycle.apply(bookDeletedEvent);
    }
    @EventSourcingHandler
    public  void on(BookDeletedEvent event) {
        this.bookId = event.getBookId();
    }
}
