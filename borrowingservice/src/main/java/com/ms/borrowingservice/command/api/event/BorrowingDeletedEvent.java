package com.ms.borrowingservice.command.api.event;

import org.axonframework.modelling.command.AggregateIdentifier;

public class BorrowingDeletedEvent {
    @AggregateIdentifier
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
