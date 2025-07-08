package exception;

public class EmptyBookException extends RuntimeException {
    public EmptyBookException(){
        super("Your Books is empty. Please add books before proceeding.");

    }
}
