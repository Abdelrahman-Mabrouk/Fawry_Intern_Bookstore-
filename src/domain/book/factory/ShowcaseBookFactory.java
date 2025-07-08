package domain.book.factory;


import domain.book.entity.Book;
import domain.book.entity.ShowcaseBookImpl;

public class ShowcaseBookFactory {

    public static ShowcaseBookImpl createShowcaseBook(
            String title,
            String author,
            String publisher,
            String isbn,
            int yearOfPublished
    ) {

        return new ShowcaseBookImpl(title, author, publisher, isbn, yearOfPublished);

    }
}

