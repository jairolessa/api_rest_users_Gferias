package gov.api_users.controller;

import gov.api_users.dto.require.UserUpdatePasswordDto;
import gov.api_users.dto.require.UsersCreateDto;
import gov.api_users.dto.require.UsersUpdateDto;
import gov.api_users.dto.response.UsersDto;
import gov.api_users.service.UsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody UsersCreateDto usersCreateDto){
        usersService.registerUser(usersCreateDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Usuário cadastrado com sucesso!");
    }

    @GetMapping("/{id}")
    public UsersDto getUser(@PathVariable Long id){
        var user = usersService.getUser(id);
        return user;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> userUpdate(@PathVariable Long id,
                                      @Valid @RequestBody UsersUpdateDto userUpdate){

        usersService.userUpdate(id, userUpdate);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Usuário editado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<UsersDto>> getUsers(){

        List<UsersDto> usersDtos = usersService.getUsers();

        return ResponseEntity
                .ok(usersDtos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable Long id,
                                                 @Valid @RequestBody UserUpdatePasswordDto userUpdatePasswordDto){

        usersService.updatePaswword(id, userUpdatePasswordDto);

        return ResponseEntity.ok("Senha alterada com sucesso!");
    }
}
