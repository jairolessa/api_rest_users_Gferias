package gov.api_users.repository;

import gov.api_users.model.UserDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDepartmentRepository extends JpaRepository<UserDepartment, Long> {
}
