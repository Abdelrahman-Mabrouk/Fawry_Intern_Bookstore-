package application.service;

import domain.book.entity.Book;
import domain.book.interfaces.EBook;
import domain.book.interfaces.PaperBook;
import exception.BookNotForSaleException;
import exception.BookNotFoundException;
import exception.OutOfStockException;

import java.util.*;

public class InventoryService {
    private final Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
    }
    public  void removeOldBooks(int yearsThreshold) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Book book : inventory.values()) {
            if (currentYear - book.getYearOfPublication() > yearsThreshold) {
                System.out.println("Removing book " + book.getTitle());
                inventory.remove(book.getIsbn());
            }
        }
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);

        if (book == null)
            throw new BookNotFoundException();

        if (!book.isForSale())
            throw new BookNotForSaleException(book.getTitle());

        if (book instanceof PaperBook paperBook) {
            if (paperBook.getStock() < quantity)
                throw new OutOfStockException(book.getTitle());

            paperBook.decreaseStock(quantity);
            new ShippingService().ship(List.of(book), address);

        } else if (book instanceof EBook) {
            new MailService().send(book,email);
        }

        return book.getPrice() * quantity;
    }

}
