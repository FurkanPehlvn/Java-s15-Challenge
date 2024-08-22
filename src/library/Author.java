package library;

import java.util.List;

public class Author extends Person {
    private List<Book> booksWritten;

    public Author(String name, List<Book> booksWritten) {
        super(name);
        this.booksWritten = booksWritten;
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }

    public void addBook(Book book) {
        this.booksWritten.add(book);
    }

    public List<Book> getBooksWritten() {
        return this.booksWritten;
    }

    public void whoYouAre() {
        System.out.println("Author");
    }

    public String toString() {
        return "Author{booksWritten=" + String.valueOf(this.booksWritten) + "}";
    }
}
