package com.rs.employeeservice.command.controller;

import com.rs.employeeservice.command.command.CreateEmployeeCommand;
import com.rs.employeeservice.command.command.DeleteEmployeeCommand;
import com.rs.employeeservice.command.command.UpdateEmployeeCommand;
import com.rs.employeeservice.command.model.EmployeeRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addEmployee(@RequestBody EmployeeRequestModel model) {
        CreateEmployeeCommand command
                = new  CreateEmployeeCommand(UUID.randomUUID().toString(), model.getFirstName(), model.getLastName(), model.getKin(), false);
        commandGateway.sendAndWait(command);
        return "created Employee";
    }

    @PutMapping
    public String updateEmployee(@RequestBody EmployeeRequestModel model) {
        UpdateEmployeeCommand command =
                new UpdateEmployeeCommand(model.getEmployeeId(), model.getFirstName(), model.getLastName(), model.getKin(), model.getDisciplined());
        commandGateway.sendAndWait(command);
        return "updated Employee";
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        DeleteEmployeeCommand command
                = new DeleteEmployeeCommand(employeeId);
        commandGateway.sendAndWait(command);
        return "deleted Employee";
    }
}
