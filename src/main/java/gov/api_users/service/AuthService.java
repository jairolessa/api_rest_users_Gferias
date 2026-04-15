package gov.api_users.service;

import gov.api_users.dto.require.LoginRequestDto;
import gov.api_users.dto.require.UsersCreateDto;
import gov.api_users.dto.response.TokenResponseDto;
import gov.api_users.mapper.UsersMapper;
import gov.api_users.model.Users;
import gov.api_users.repository.UsersRepository;
import gov.api_users.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UsersMapper usersMapper;

    public TokenResponseDto register(UsersCreateDto dto){
        Users user = usersMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        usersRepository.save(user);

        String token = jwtService.generateToken(user.getCpf(), user.getRole().toString());
        return new TokenResponseDto(token, "Bearer ");
    }

    public TokenResponseDto login(LoginRequestDto dto) {
        Users user = usersRepository.findByCpf(dto.cpf())
                .orElseThrow(() -> new BadCredentialsException("Credenciais inválidas"));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        String token = jwtService.generateToken(user.getCpf(), user.getRole().toString());
        return new TokenResponseDto(token, "Bearer");
    }
}
