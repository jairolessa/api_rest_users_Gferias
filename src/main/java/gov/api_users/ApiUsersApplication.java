package gov.api_users;

import gov.api_users.model.Role;
import gov.api_users.model.UserType;
import gov.api_users.model.Users;
import gov.api_users.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsersApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDefaultAdminUser(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			String defaultCpf = "11066394482";
			String defaultPassword = "123456";

			Users admin = usersRepository.findByCpf(defaultCpf).orElseGet(Users::new);
			admin.setFullName("Administrador Padrao");
			admin.setCpf(defaultCpf);
			admin.setJobTitle("Administrador");
			admin.setUserType(UserType.MANAGER);
			admin.setRole(Role.ROLE_ADMIN);
			admin.setActive(true);

			if (admin.getPassword() == null || !passwordEncoder.matches(defaultPassword, admin.getPassword())) {
				admin.setPassword(passwordEncoder.encode(defaultPassword));
			}

			usersRepository.save(admin);
		};
	}
}
