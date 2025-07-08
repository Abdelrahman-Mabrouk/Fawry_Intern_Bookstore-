package domain.book.entity;

public abstract class Book {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int yearOfPublication;
    private int price;
    public Book(String title, String author, String publisher, String isbn, int yearOfPublication,int price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.yearOfPublication = yearOfPublication;
        this.price = price;

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getYearOfPublication() {
        return yearOfPublication;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    abstract
    public boolean isForSale();

}
