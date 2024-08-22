//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package library;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Library {
    private Set<Book> books = new HashSet();
    private List<Reader> readers = new ArrayList();
    private Set<MemberRecord> members = new HashSet();

    public Library() {
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<MemberRecord> getMembers() {
        return this.members;
    }

    public void setMembers(Set<MemberRecord> members) {
        this.members = members;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public List<Reader> getReaders() {
        return this.readers;
    }

    public void addBook(Book book) {
        Iterator var2 = this.books.iterator();

        Book b;
        do {
            if (!var2.hasNext()) {
                this.books.add(book);
                System.out.println("Book with ID " + book.getBook_ID() + " added successfully.");
                return;
            }

            b = (Book)var2.next();
        } while(b.getBook_ID() != book.getBook_ID());

        System.out.println("Warning: A book with ID " + book.getBook_ID() + " already exists.");
    }

    public MemberRecord findMemberById(long memberId) {
        Iterator var3 = this.members.iterator();

        MemberRecord member;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            member = (MemberRecord)var3.next();
        } while(member.getMember_ID() != memberId);

        return member;
    }

    public void lendBook(Book book, Reader reader) {
        if (book.isStatus()) {
            book.setStatus(false);
            book.setBorrowedBy(reader);
            reader.getBorrowedBooks().add(book);
            System.out.println("Book lent to reader: " + reader.getName());
        } else {
            System.out.println("Cannot lend book. Book is already borrowed by " + book.getBorrowedBy().getName());
        }

    }

    public void takeBackBook(Book book, Reader reader) {
        if (reader.getBorrowedBooks().contains(book)) {
            book.setStatus(true);
            reader.getBorrowedBooks().remove(book);
            System.out.println("Book returned by reader: " + reader.getName());
        } else {
            System.out.println("This book was not borrowed by this reader.");
        }

    }

    public void showBook() {
    }

    public void removeBook(long book_ID) {
        this.books.removeIf((book) -> {
            return book.getBook_ID() == book_ID;
        });
    }

    public Book findBookById(long book_ID) {
        Iterator var3 = this.books.iterator();

        Book book;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            book = (Book)var3.next();
        } while(book.getBook_ID() != book_ID);

        return book;
    }

    public List<Book> findBooksByName(String name) {
        List<Book> result = new ArrayList();
        Iterator var3 = this.books.iterator();

        while(var3.hasNext()) {
            Book book = (Book)var3.next();
            if (book.getTitle().equalsIgnoreCase(name)) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList();
        Iterator var3 = this.books.iterator();

        while(var3.hasNext()) {
            Book book = (Book)var3.next();
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> listBooksByCategory(Edition edition) {
        List<Book> result = new ArrayList();
        Iterator var3 = this.books.iterator();

        while(var3.hasNext()) {
            Book book = (Book)var3.next();
            if (book.getEdition() == edition) {
                result.add(book);
            }
        }

        return result;
    }

    public void addReader(Reader reader) {
        this.readers.add(reader);
    }

    public void addMember(MemberRecord memberRecord) {
        this.members.add(memberRecord);
    }

    public String toString() {
        String var10000 = String.valueOf(this.books);
        return "Library{books=" + var10000 + ", readers=" + String.valueOf(this.readers) + "}";
    }
}
