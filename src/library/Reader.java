//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package library;

import java.util.List;

public class Reader extends Person {
    private List<Book> borrowedBooks;
    private Library library;
    private Librarian librarian;

    public Reader(String name, List<Book> borrowedBooks, Library library) {
        super(name);
        this.borrowedBooks = borrowedBooks;
        this.library = library;
    }

    public List<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void purchaseBook(Book book) {
        if (this.librarian.createBill(book, this)) {
            this.borrowedBooks.add(book);
            this.library.removeBook(book.getBook_ID());
            System.out.println("Book purchased and added to your collection: " + book.getTitle());
        } else {
            System.out.println("Purchase failed.");
        }

    }

    public void borrowBook(Library library, Book book) {
        if (book.isStatus() && this.borrowedBooks.size() < 5) {
            book.setStatus(false);
            this.borrowedBooks.add(book);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Cannot borrow book. Either the book is unavailable or you have reached your borrow limit.");
        }

    }

    public List<Book> showBook() {
        return this.borrowedBooks;
    }

    public void whoYouAre() {
        System.out.println("Reader");
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "Reader{"+ super.getName()+" " +
                "borrowedBooks=" + borrowedBooks +

                '}';
    }
}
