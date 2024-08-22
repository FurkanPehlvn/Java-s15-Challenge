package library;

import java.util.Date;
import java.util.Objects;

public class Book {
    private long book_ID;
    private String author;
    private String name;
    private int price;
    private boolean status;
    private Edition edition;
    private Date dateOfPurchase;
    private Reader borrowedBy;

    public Book(long book_ID, String author, String name, int price, boolean status, Edition edition, Date dateOfPurchase) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.borrowedBy = null;
    }

    public long getBook_ID() {
        return this.book_ID;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isStatus() {
        return this.status;
    }

    public Edition getEdition() {
        return this.edition;
    }

    public Date getDateOfPurchase() {
        return this.dateOfPurchase;
    }

    public String getTitle() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setBook_ID(long book_ID) {
        this.book_ID = book_ID;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void changeOwner() {
    }

    public void getOwner() {
    }

    public void display() {
    }

    public boolean updateStatus() {
        return !this.status;
    }

    public Reader getBorrowedBy() {
        return this.borrowedBy;
    }

    public void setBorrowedBy(Reader borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object != null && this.getClass() == object.getClass()) {
            Book book = (Book)object;
            return this.book_ID == book.book_ID;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.book_ID);
    }

    public String toString() {
        long var10000 = this.book_ID;
        return "Book{book_ID=" + var10000 + ", author='" + this.author + "', name='" + this.name + "', price=" + this.price + ", status=" + this.status + ", edition=" + String.valueOf(this.edition) + ", dateOfPurchase=" + String.valueOf(this.dateOfPurchase) + ", borrowedBy=" + String.valueOf(this.borrowedBy) + "}";
    }
}