package exception;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String bookTitle) {
        super("The book \"" + bookTitle + "\" is out of stock.");
    }
}
