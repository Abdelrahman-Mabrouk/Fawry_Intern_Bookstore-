package exception;

public class AddressEmptyException extends RuntimeException {
    public AddressEmptyException() {
        System.out.println("Address is empty");
    }
}
