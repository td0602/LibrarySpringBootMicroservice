package com.ms.borrowingservice.command.api.event;

import com.ms.borrowingservice.command.api.data.Borrowing;
import com.ms.borrowingservice.command.api.data.BorrowingRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BorrowingEventHandler {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @EventHandler
    public void on(BorrowingCreatedEvent event) {
        Borrowing model = new Borrowing();
        BeanUtils.copyProperties(event, model);
        borrowingRepository.save(model);
    }
}
