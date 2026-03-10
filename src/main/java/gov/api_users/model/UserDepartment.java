package gov.api_users.model;

import jakarta.persistence.*;

@Entity
public class UserDepartment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "departmenr_id", nullable = false)
    private Department department;
}
