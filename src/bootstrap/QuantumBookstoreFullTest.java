package bootstrap;

import application.service.InventoryService;
import domain.book.entity.*;
import domain.book.factory.EBookFactory;
import domain.book.factory.PaperBookFactory;
import domain.book.factory.ShowcaseBookFactory;
import domain.customer.entity.Customer;

public class QuantumBookstoreFullTest {

    public static void run() {
        InventoryService inventory = new InventoryService();


        //================================ Create books
        PaperBookImpl paper = PaperBookFactory.createPaperBook("Clean Code", "Robert C. Martin", "Prentice Hall", "9780132350884", 2008, 50, 0.5, 10);
        EBookImpl ebook = EBookFactory.createEBook("Head First Java", "Kathy Sierra", "O'Reilly Media", "9780596009205", 2005, 30, "PDF");
        ShowcaseBookImpl showcaseBook = ShowcaseBookFactory.createShowcaseBook("Java Showcase", "Jane Doe", "Tech Books", "1234567890", 2020);


// Add books
        inventory.addBook(paper);
        inventory.addBook(ebook);

// Buy book
        Customer customer = new Customer("John", "john@mail.com", "Cairo");
        inventory.buyBook(paper.getIsbn(), 2, customer.getEmail(), customer.getAddress(), true);

    }
}


