package domain.book.interfaces;

public interface PaperBook {
    boolean isForSale = true;
    int getStock();
    void decreaseStock(int stock);
}
