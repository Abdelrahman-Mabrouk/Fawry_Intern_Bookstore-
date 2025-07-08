package application.service;

import domain.book.entity.Book;
import domain.book.interfaces.PaperBook;
import exception.AddressEmptyException;
import exception.EmptyBookException;

import java.util.List;

public class ShippingService {


    public void ship(Book book, String address){
        if (book == null) {
            throw new EmptyBookException();
        }
        if (book instanceof PaperBook) {
            if (address.isEmpty()) {
                throw new AddressEmptyException();
            }
            System.out.println("Starting shipment to: " + address);
            System.out.println(book.getTitle() + " shipped successfully.");
        }
        else {
            System.out.println("book must be paper book");
        }
    }
}
