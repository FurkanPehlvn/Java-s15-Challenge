//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package library;

import java.util.Iterator;
import java.util.List;

public class Librarian {
    private String name;
    private String password;
    private Library library;
    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public void searchBook(Library library, String bookName) {
        List<Book> books = library.findBooksByName(bookName);
        if (!books.isEmpty()) {
            System.out.println("Book found: ");
            Iterator var4 = books.iterator();

            while(true) {
                while(true) {
                    Book book;
                    do {
                        if (!var4.hasNext()) {
                            return;
                        }

                        book = (Book)var4.next();
                        System.out.println(book+" "+"Book Id:"+ book.getBook_ID());

                    } while(book.isStatus());

                    Iterator var6 = library.getReaders().iterator();

                    while(var6.hasNext()) {
                        Reader reader = (Reader)var6.next();
                        if (reader.getBorrowedBooks().contains(book)) {
                            System.out.println("This book is currently borrowed by: " + reader.getName());
                            break;
                        }
                    }
                }
            }
        } else {
            System.out.println("Book is not found with the name: " + bookName);
        }
    }

    public void verifyMember(Library library, long memberId) {
        MemberRecord member = library.findMemberById(memberId);
        if (member != null) {
            System.out.println("Member verified: " + String.valueOf(member));
        } else {
            System.out.println("Member not found.");
        }

    }

    public void issueBook(Library library, long bookId, long memberId) {
        MemberRecord member = library.findMemberById(memberId);
        Book book = library.findBookById(bookId);
        if (member != null) {
            if (book != null && book.isStatus()) {
                if (member.getBooksIssued() < member.getMaxBookLimit()) {
                    book.setStatus(false);
                    member.incrementBooksIssued();
                    System.out.println("Book issued to member: " + member.getMemName());
                } else {
                    System.out.println("Cannot issue book. Member has reached the borrowing limit.");
                }
            } else {
                System.out.println("Cannot issue book. Book is not available.");
            }
        } else {
            System.out.println("Member not found.");
        }

    }

    public void calculateFine() {
    }

    public boolean createBill(Book book, Reader reader) {
        Bill bill = new Bill(reader, book, book.getPrice(), false);
        System.out.println("Bill created: " + String.valueOf(bill));
        return true;
    }

    public void returnBook(Library library, long bookId, long memberId) {
        Book book = library.findBookById(bookId);
        MemberRecord member = library.findMemberById(memberId);
        if (book != null && member != null && !book.isStatus()) {
            if (member.getBooksIssued() > 0) {
                member.decrementBooksIssued();
                book.setStatus(true);
                System.out.println("Book returned by member: " + member.getMember_ID());
            } else {
                System.out.println("No books are currently issued to this member.");
            }
        } else {
            System.out.println("Book not found, not currently borrowed, or member not found.");
        }

    }


    public String toString() {
        return "Librarian{name='" + this.name + "', password='" + this.password + "'}";
    }
}
