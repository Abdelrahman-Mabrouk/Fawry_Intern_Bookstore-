package exception;

public class BookNotForSaleException extends RuntimeException {
    public BookNotForSaleException(String bookTitle) {
        super("The book \"" + bookTitle + "\" is not available for sale.");
    }
}
