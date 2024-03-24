package com.ms.borrowingservice.command.api.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeteleBorrowingCommand {
    @TargetAggregateIdentifier
    private String id;

    public DeteleBorrowingCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
