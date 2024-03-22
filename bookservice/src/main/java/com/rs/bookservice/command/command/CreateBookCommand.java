package com.rs.bookservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateBookCommand {
    @TargetAggregateIdentifier // dinh nghia bookId nay laf Aggregate Identifier
    private String BookId;
    private String name;
    private String author;
    private Boolean isReady;

    public CreateBookCommand(String bookId, String name, String author, Boolean isReady) {
        BookId = bookId;
        this.name = name;
        this.author = author;
        this.isReady = isReady;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getReady() {
        return isReady;
    }

    public void setReady(Boolean ready) {
        isReady = ready;
    }
}
