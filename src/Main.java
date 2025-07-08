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
        JavaShowcaseBook showcaseBook = new JavaShowcaseBook("Java Showcase", "Jane Doe", "Tech Books", "1234567890", 2020);

        //================================ Add books to inventory
        inventory.addBook(cleanCode);
        inventory.addBook(headFirstJava);
        inventory.addBook(showcaseBook);

        //================================ Create a customer
        Customer customer = new Customer("Mabrouk", "Mabrouk@example.com", "123 Mabrouk St");

        //================================ Try to buy a paper book
        try {
            inventory.buyBook(cleanCode.getIsbn(), 2, customer.getEmail(), customer.getAddress(), true);
        } catch (RuntimeException e) {
            System.out.println("Error purchasing paper book: " + e.getMessage());
        }

        System.out.println("=".repeat(20));
        //================================ Try to buy an ebook
        try {
            inventory.buyBook(headFirstJava.getIsbn(), 1, customer.getEmail(), customer.getAddress(), false);
        } catch (RuntimeException e) {
            System.out.println("Error purchasing ebook: " + e.getMessage());
        }


        System.out.println("=".repeat(20));
        //================================ Try to buy a showcase book (not for sale)
        try {
            inventory.buyBook(showcaseBook.getIsbn(), 1, customer.getEmail(), customer.getAddress(), false);
        } catch (RuntimeException e) {
            System.out.println("Error purchasing showcase book: " + e.getMessage());
        }


        System.out.println("=".repeat(20));
        //================================ Try to remove old books
        try {
            inventory.removeOldBooks(10);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}