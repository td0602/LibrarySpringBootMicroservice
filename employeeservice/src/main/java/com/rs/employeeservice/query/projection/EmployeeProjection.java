package com.rs.employeeservice.query.projection;

import com.rs.employeeservice.command.data.Employee;
import com.rs.employeeservice.command.data.EmployeeRepository;
import com.rs.employeeservice.query.model.EmployeeResponseModel;
import com.rs.employeeservice.query.queries.GetAllEmployeeQuery;
import com.rs.employeeservice.query.queries.GetEmployeeQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjection {
    @Autowired
    private EmployeeRepository employeeRepository;
    @QueryHandler
    public EmployeeResponseModel handle(GetEmployeeQuery getEmployeeQuery) {
        EmployeeResponseModel model = new EmployeeResponseModel();
        Employee employee = employeeRepository.getById(getEmployeeQuery.getEmployeeId());
        BeanUtils.copyProperties(employee, model);
        return model;
    }

    @QueryHandler
    public List<EmployeeResponseModel> handle(GetAllEmployeeQuery getAllEmployeeQuery) {
        List<EmployeeResponseModel> list = new ArrayList<>();
        List<Employee> listEntities = employeeRepository.findAll();
        listEntities.forEach(e -> {
            EmployeeResponseModel model = new EmployeeResponseModel();
            BeanUtils.copyProperties(e, model);
            list.add(model);
        });
        return list;
    }
}
