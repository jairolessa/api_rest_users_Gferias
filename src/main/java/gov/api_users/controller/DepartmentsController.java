package gov.api_users.controller;

import gov.api_users.model.Department;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    @PostMapping("/register")
    public void registerDepartment(@RequestBody Department department){

        System.out.println(department);

    }
}
