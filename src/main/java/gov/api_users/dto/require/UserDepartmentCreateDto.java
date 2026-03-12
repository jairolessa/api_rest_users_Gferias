package gov.api_users.dto.require;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDepartmentCreateDto {

    @NotNull
    private Long userId;

    @NotNull
    private List<Long> departmentsIds;
}
