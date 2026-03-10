package gov.api_users.exceptions;

public class InsufficientVacationDaysException extends RuntimeException {

    public InsufficientVacationDaysException(String msg) {
        super(msg);
    }
}