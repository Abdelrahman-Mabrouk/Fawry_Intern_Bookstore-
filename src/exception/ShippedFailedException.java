package exception;

public class ShippedFailedException extends RuntimeException {
        public ShippedFailedException(String reason) {
            super("Shipped failed: " + reason);
        }
    }

