package domain.book.factory;


import domain.book.entity.Book;
import domain.book.entity.PaperBookImpl;


public class PaperBookFactory {

    public static PaperBookImpl createPaperBook(
            String title,
            String author,
            String publisher,
            String isbn,
            int yearOfPublished,
            double price,
            double weight,
            int stock
    ) {
        return new PaperBookImpl(title, author, publisher, isbn, yearOfPublished, price, weight, stock);

    }
}

