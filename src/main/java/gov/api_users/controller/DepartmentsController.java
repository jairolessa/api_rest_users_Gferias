package gov.api_users.controller;

import gov.api_users.dto.require.DepartmentCreateDto;
import gov.api_users.dto.require.DepartmentUpdateListUsersDto;
import gov.api_users.service.DepartmentsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    @PostMapping
    public ResponseEntity<?> registerDepartment(@RequestBody @Valid DepartmentCreateDto departmentCreateDto){

        departmentsService.registerDepartment(departmentCreateDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Departamento criado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable Long id){

        return ResponseEntity
                .ok(departmentsService.getDepartment(id));
    }

    @GetMapping
    public ResponseEntity<?> getDepartments(){
        return ResponseEntity.ok(departmentsService.getDepartments());
    }
}
