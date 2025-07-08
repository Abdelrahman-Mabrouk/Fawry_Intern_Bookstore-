package application.service;

import domain.book.entity.Book;
import domain.book.interfaces.PaperBook;
import exception.AddressEmptyException;
import exception.EmptyBookException;

import java.util.List;

public class ShippingService {


    public void ship(List<Book> Books, String address){
        if (Books instanceof PaperBook) {
            if (Books.isEmpty()) {
                throw new EmptyBookException();
            }
            if (address.isEmpty()) {
                throw new AddressEmptyException();
            }
            System.out.println("Starting shipment to: " + address);
            for (Book item : Books) {
                System.out.println("- Shipping: " + item.getTitle());
            }
            System.out.println("All items shipped successfully.");
        }
        else {
            System.out.println("books must be paper book");
        }
    }
}
