package domain.book.entity;

import domain.book.interfaces.PaperBook;
import domain.book.interfaces.ShippableBook;

public class CleanCode extends Book implements PaperBook,ShippableBook {
    double weight;
    int stock;
    public CleanCode(String title, String author, String publisher, String isbn, int yearOfPublication, double price, double weight,int stock) {
        super(title, author, publisher, isbn, yearOfPublication, price);
        this.weight = weight;
        this.stock = stock;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void decreaseStock(int stock) {
        this.stock = this.stock - stock;
    }

    @Override
    public boolean isForSale() {
        return isForSale;
    }
}
