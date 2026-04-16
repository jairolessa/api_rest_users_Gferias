package gov.api_users.dto.response;

import lombok.Data;

@Data
public class UserCreatedEvent {

    private Long id;
    private String fullName;
    private String cpf;
    private String jobTitle;
    private Boolean active;
}
