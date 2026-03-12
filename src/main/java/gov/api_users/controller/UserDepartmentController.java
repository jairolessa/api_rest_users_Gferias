package gov.api_users.controller;

import gov.api_users.dto.require.UserDepartmentCreateDto;
import gov.api_users.service.UserDepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user-department")
public class UserDepartmentController {

    private final UserDepartmentService userDepartmentService;

    @PostMapping
    public ResponseEntity<?> associeteUserDepartment(@Valid @RequestBody UserDepartmentCreateDto userDepartmentCreateDto){
        userDepartmentService.registerUserDepartment(userDepartmentCreateDto);

        return ResponseEntity.ok("Usuário associado ao departamento com sucesso!");
    }
}
