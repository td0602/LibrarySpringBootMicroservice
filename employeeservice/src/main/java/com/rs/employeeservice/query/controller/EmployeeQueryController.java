package com.rs.employeeservice.query.controller;

import com.rs.employeeservice.query.model.EmployeeResponseModel;
import com.rs.employeeservice.query.queries.GetAllEmployeeQuery;
import com.rs.employeeservice.query.queries.GetEmployeeQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/{employeeId}")
    public EmployeeResponseModel getEmployeeDetail(@PathVariable String employeeId){
        GetEmployeeQuery getEmployeeQuery = new GetEmployeeQuery();
        getEmployeeQuery.setEmployeeId(employeeId);

        EmployeeResponseModel model
                = queryGateway.query(getEmployeeQuery, ResponseTypes.instanceOf(EmployeeResponseModel.class)).join();
        return model;
    }

    @GetMapping
    public List<EmployeeResponseModel> getAllEmployee() {
        GetAllEmployeeQuery getAllEmployeeQuery
                = new GetAllEmployeeQuery();
        List<EmployeeResponseModel> list = queryGateway.query(getAllEmployeeQuery, ResponseTypes.multipleInstancesOf(EmployeeResponseModel.class)).join();
        return list;
    }
}
