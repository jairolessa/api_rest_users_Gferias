package gov.api_users.service;

import gov.api_users.controller.exceptions.ResourceAlreadyExistsException;
import gov.api_users.dto.require.UserUpdatePasswordDto;
import gov.api_users.dto.require.UsersCreateDto;
import gov.api_users.dto.require.UsersUpdateDto;
import gov.api_users.dto.response.UsersDto;
import gov.api_users.mapper.UsersMapper;
import gov.api_users.model.Users;
import gov.api_users.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsersMapper usersMapper;

    public void registerUser(UsersCreateDto usersCreateDto){

        if(usersRepository.findByCpf(usersCreateDto.getCpf()).isPresent()){
            throw new RuntimeException("Usuário já existe!");
        }
        Users entity = usersMapper.toEntity(usersCreateDto);
        this.setPasswordEncoder(entity);
        usersRepository.save(entity);
    }

    public UsersDto getUser(Long id) {
        Users user = getUserById(id);
        return usersMapper.toDto(user);
    }

    // MANTER APENAS ESTA VERSÃO (A antiga foi removida daqui)
    public void userUpdate(Long id, UsersUpdateDto usersUpdateDto) {
        Users user = this.getUserById(id);

        // REGRA NOVA: Se o usuário estiver inativo, bloqueia a edição
        if (user.getActive() == null || !user.getActive()) {
            throw new InvalidUserStatusException("Não é possível alterar dados de um usuário inativo!");
        }

        int solicitados = (usersUpdateDto.getDiasSolicitados() == null) ? 0 : usersUpdateDto.getDiasSolicitados();
        int saldoDisponivel = (user.getSaldoFerias() == null) ? 0 : user.getSaldoFerias();

        if (solicitados > saldoDisponivel) {
            throw new InsufficientVacationDaysException("Saldo insuficiente!");
        }

        usersMapper.updateToEntity(usersUpdateDto, user);
        usersRepository.save(user);
    }

    public List<UsersDto> getUsers() {
        return usersMapper.toListDto(usersRepository.findAll());
    }

    public void updatePaswword(Long id, UserUpdatePasswordDto userUpdatePasswordDto) {
        Users user = getUserById(id);
        if (!passwordEncoder.matches(userUpdatePasswordDto.getCurrentPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A senha atual está incorreta!");
        }
        user.setPassword(userUpdatePasswordDto.getNewPassword());
        setPasswordEncoder(user);
        usersRepository.save(user);
    }

    private Users getUserById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário não encontrado!"
                ));
    }

    private void setPasswordEncoder(Users user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
    }


}