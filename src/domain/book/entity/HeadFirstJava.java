package domain.book.entity;

import domain.book.interfaces.EBook;


public class HeadFirstJava extends Book implements EBook {
    String fileType;
    public HeadFirstJava(String title, String author, String publisher, String isbn, int yearOfPublication, double price, String fileType) {
        super(title, author, publisher, isbn,yearOfPublication,price);
        this.fileType = fileType;
    }

    @Override
    public String fileType() {
        return fileType;
    }

    @Override
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }


    @Override
    public boolean isForSale() {
        return isForSale;
    }
}
