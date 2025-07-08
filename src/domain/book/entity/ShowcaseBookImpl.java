package domain.book.entity;

import domain.book.interfaces.ShowcaseBook;

public class ShowcaseBookImpl extends Book implements ShowcaseBook {
    public ShowcaseBookImpl(String title, String author, String publisher, String isbn, int yearOfPublication) {
        super(title, author, publisher, isbn, yearOfPublication, price);
    }

    @Override
    public boolean isForSale() {
        return isForSale;
    }
}
