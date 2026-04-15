package gov.api_users.dto.response;

public record TokenResponseDto(
        String token,
        String type
) {
}
