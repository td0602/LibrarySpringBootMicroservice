package com.rs.employeeservice.command.aggregate;

import com.rs.employeeservice.command.command.CreateEmployeeCommand;
import com.rs.employeeservice.command.command.DeleteEmployeeCommand;
import com.rs.employeeservice.command.command.UpdateEmployeeCommand;
import com.rs.employeeservice.command.event.EmployeeCreateEvent;
import com.rs.employeeservice.command.event.EmployeeDeleteEvent;
import com.rs.employeeservice.command.event.EmployeeUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class EmployeeAggregate {
    @AggregateIdentifier
    private String employeeId;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean idDisciplined;

    public EmployeeAggregate() {

    }

    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand command) {
        EmployeeCreateEvent event =  new EmployeeCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public void handle(UpdateEmployeeCommand command) {
        EmployeeUpdateEvent event = new EmployeeUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public void handle(DeleteEmployeeCommand command) {
        EmployeeDeleteEvent event = new EmployeeDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(EmployeeCreateEvent event) {
        this.employeeId = event.getEmployeeId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.idDisciplined = event.getDisciplined();
    }

    @EventSourcingHandler
    public void on(EmployeeUpdateEvent event) {
        this.employeeId = event.getEmployeeId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.idDisciplined = event.getDisciplined();
    }
    @EventSourcingHandler
    public void on(EmployeeDeleteEvent event) {
        this.employeeId = event.getEmployeeId();
    }
}
