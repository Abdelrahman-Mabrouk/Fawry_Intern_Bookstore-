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
        Iterator<Book> iterator = inventory.values().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (currentYear - book.getYearOfPublication() > yearsThreshold) {
                System.out.println("Removing book " + book.getTitle());
                iterator.remove();
            }
        }
    }



    public void buyBook(String isbn, int quantity, String email, String address , boolean isShipp) {
        Book book = inventory.get(isbn);

        if (book == null)
            throw new BookNotFoundException();

        if (!book.isForSale())
            throw new BookNotForSaleException(book.getTitle());

        if (book instanceof PaperBook paperBook) {
            if (paperBook.getStock() < quantity)
                throw new OutOfStockException(book.getTitle());

            paperBook.decreaseStock(quantity);
            if (isShipp)
                new ShippingService().ship(book, address);
            else
                System.out.println("Successfully purchased " + quantity + " copy(ies) of '" + book.getTitle() + "' for $" + book.getPrice()* quantity + ".");

        } else if (book instanceof EBook) {
            new MailService().send(book,email);
        }

    }

}
