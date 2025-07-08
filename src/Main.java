import application.service.InventoryService;
import domain.book.entity.CleanCode;
import domain.book.entity.HeadFirstJava;
import domain.book.entity.JavaShowcaseBook;
import domain.customer.entity.Customer;
import exception.*;

public class Main {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();

        //================================ Create books
        CleanCode cleanCode = new CleanCode("Clean Code", "Robert C. Martin", "Prentice Hall", "9780132350884", 2008, 50, 0.5, 10);
        HeadFirstJava headFirstJava = new HeadFirstJava("Head First Java", "Kathy Sierra", "O'Reilly Media", "9780596009205", 2005, 30, "PDF");
        JavaShowcaseBook showcaseBook = new JavaShowcaseBook("Java Showcase", "Jane Doe", "Tech Books", "1234567890", 2020, 40);

        //================================ Add books to inventory
        inventory.addBook(cleanCode);
        inventory.addBook(headFirstJava);
        inventory.addBook(showcaseBook);

        //================================ Create a customer
        Customer customer = new Customer("Alice", "alice@example.com", "123 Main St");

        //================================ Try to buy a paper book
        try {
            double total = inventory.buyBook(cleanCode.getIsbn(), 2, customer.getEmail(), customer.getAddress());
            System.out.println("Purchased 2 copies of '" + cleanCode.getTitle() + "' for $" + total);
        } catch (RuntimeException e) {
            System.out.println("Error purchasing paper book: " + e.getMessage());
        }

        //================================ Try to buy an ebook
        try {
            double total = inventory.buyBook(headFirstJava.getIsbn(), 1, customer.getEmail(), customer.getAddress());
            System.out.println("Purchased 1 copy of '" + headFirstJava.getTitle() + "' for $" + total);
        } catch (RuntimeException e) {
            System.out.println("Error purchasing ebook: " + e.getMessage());
        }

        //================================ Try to buy a showcase book (not for sale)
        try {
            inventory.buyBook(showcaseBook.getIsbn(), 1, customer.getEmail(), customer.getAddress());
        } catch (RuntimeException e) {
            System.out.println("Error purchasing showcase book: " + e.getMessage());
        }
    }
}