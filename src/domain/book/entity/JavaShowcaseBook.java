package domain.book.entity;

import domain.book.interfaces.ShowcaseBook;

public class JavaShowcaseBook extends Book implements ShowcaseBook {
    public JavaShowcaseBook(String title, String author, String publisher, String isbn, String yearOfPublication, int price) {
        super(title, author, publisher, isbn, yearOfPublication, price);
    }

    @Override
    public boolean isForSale() {
        return isForSale;
    }

}
