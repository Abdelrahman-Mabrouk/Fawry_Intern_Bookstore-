package application.service;

import domain.book.entity.Book;
import domain.book.interfaces.PaperBook;
import domain.book.interfaces.ShippableBook;
import exception.AddressEmptyException;
import exception.EmptyBookException;
import exception.ShippedFailedException;

import java.awt.print.Paper;
import java.util.List;

public class ShippingService {


    public void ship(Book book, String address){
        if (book == null) {
            throw new EmptyBookException();
        }
        if (book instanceof PaperBook paperBook && book instanceof ShippableBook shippableBook) {
            if (address.isEmpty()) {
                throw new AddressEmptyException();
            }
            System.out.println("Starting shipment to: " + address);
            System.out.println("The Cost of Shipping is: " + shipCost(book));
            System.out.println(book.getTitle() + " shipped successfully.");
        }
        else {
            System.out.println("book must be paper book");
        }
    }
    public double shipCost(Book book){
        if (book instanceof ShippableBook shippableBook) {
            return shippableBook.getWeight() * 10;
        }
        else {
            throw new ShippedFailedException("Is not a shippable book");
        }
    }
}
