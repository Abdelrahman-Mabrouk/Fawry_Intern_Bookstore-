package application.service;

import domain.book.entity.Book;
import exception.InvalidEmailException;

import java.util.List;

public class MailService {
    public void send(Book book, String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException(email);
        }

        System.out.println("Sending e-books to: " + email);
        System.out.println("- Sent: " + book.getTitle());
        System.out.println("✅ e-books sent successfully.");
    }
}
