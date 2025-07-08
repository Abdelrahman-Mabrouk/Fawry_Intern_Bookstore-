package exception;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String email) {
        super("The email address \"" + email + "\" is invalid or not provided.");
    }
}
