package com.rs.employeeservice.command.event;

import com.rs.employeeservice.command.data.Employee;
import com.rs.employeeservice.command.data.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventHandler {
    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    public void on(EmployeeCreateEvent event) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }

    @EventHandler
    public void on(EmployeeUpdateEvent event) {
        Employee employee = employeeRepository.getById(event.getEmployeeId());
        employee.setFirstName(event.getFirstName());
        employee.setLastName(event.getLastName());
        employee.setKin(event.getKin());
        employee.setDisciplined(event.getDisciplined());
        employeeRepository.save(employee);
    }
    @EventHandler
    public void on(EmployeeDeleteEvent event) {
        employeeRepository.deleteById(event.getEmployeeId());
    }

}
