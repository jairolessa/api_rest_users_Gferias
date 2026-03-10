package gov.api_users.controller;

import gov.api_users.dto.require.DepartmentCreateDto;
import gov.api_users.model.Department;
import gov.api_users.service.DepartmentsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    @PostMapping
    public ResponseEntity<?> registerDepartment(@RequestBody @Valid DepartmentCreateDto departmentCreateDto){
        System.out.println(departmentCreateDto.toString());
        departmentsService.registerDepartment(departmentCreateDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Departamento cadastrado com sucesso!");
    }
}
