package domain.book.factory;

import domain.book.entity.Book;
import domain.book.entity.EBookImpl;
import domain.book.entity.PaperBookImpl;

public class EBookFactory {
    public static EBookImpl createEBook(
            String title,
            String author,
            String publisher,
            String isbn,
            int yearOfPublished,
            double price,
            String fileType
    ) {
        return new EBookImpl(title, author, publisher, isbn, yearOfPublished,price,fileType);

    }
}
