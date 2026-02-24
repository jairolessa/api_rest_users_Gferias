package gov.api_users.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserType {

    MANAGER("Administrador"),
    LEADERSHIP("Chefia"),
    PUBLICSERVICE("Servidor Público");

    private String userType;
}
