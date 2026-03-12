package gov.api_users.controller;

import gov.api_users.dto.require.DepartmentCreateDto;
import gov.api_users.dto.response.DepartmentDto;
import gov.api_users.service.DepartmentsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    @PostMapping
    public ResponseEntity<String> registerDepartment(@RequestBody @Valid DepartmentCreateDto departmentCreateDto){

        departmentsService.registerDepartment(departmentCreateDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Departamento criado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long id){

        return ResponseEntity
                .ok(departmentsService.getDepartment(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartments(){
        return ResponseEntity.ok(departmentsService.getDepartments());
    }
}
