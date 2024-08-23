//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import library.Book;
import library.Edition;
import library.Faculty;
import library.Librarian;
import library.Library;
import library.Reader;
import library.Student;
import library.Type;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Mahmut", "sifre");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        library.addReader(new Reader("Alice", new ArrayList<>(), library));
        library.addReader(new Reader("Bob", new ArrayList<>(), library));
        library.addMember(new Student(1L, Type.STUDENT, new Date(), 0, 5, "Ahmet", "Istanbul", "123456"));
        library.addMember(new Faculty(2L, Type.FACULTY, new Date(), 0, 5, "Berk", "Istanbul", "345678"));
        library.addBook(new Book(1L, "Orhan", "Araba", 10, true, Edition.JOURNALS, new Date()));
        library.addBook(new Book(2L, "Mese", "Yangın", 15, true, Edition.STUDYBOOKS, new Date()));
        library.addBook(new Book(3L, "Fatma", "Uzaylı", 10, true, Edition.JOURNALS, new Date()));

        while(true) {
            label110:
            while(!exit) {
                System.out.println("\nWelcome to Library");
                System.out.println("1. Librarian Operations");
                System.out.println("2. List Books by Edition");
                System.out.println("3. List Books by Author");
                System.out.println("4. List All Books");
                System.out.println("5. Borrow Book");
                System.out.println("6. Return Book");
                System.out.println("7. Add Book");
                System.out.println("8. Update Book");
                System.out.println("9. Delete Book");
                System.out.println("10. Exit");
                System.out.println("Choose an option:");
                int choice = scanner.nextInt();
                scanner.nextLine();
                long memId;
                switch (choice) {
                    case 1:
                        System.out.println("Enter Librarian Name: ");
                        String libName = scanner.nextLine();
                        System.out.println("Enter Librarian Password: ");
                        String libPass = scanner.nextLine();
                        if (librarian.getName().equals(libName) && librarian.getPassword().equals(libPass)) {
                            boolean librarianExit = false;

                            while(true) {
                                if (librarianExit) {
                                    continue label110;
                                }

                                System.out.println("Librarian operations:");
                                System.out.println("1. Search Book by Name");
                                System.out.println("2. Verify Member");
                                System.out.println("3. Issue Book");
                                System.out.println("4. Return Book");
                                System.out.println("5. Calculate Fine");
                                System.out.println("6.List of readers");
                                System.out.println("7. Exit Librarian Operations");
                                System.out.print("Choose an option: ");
                                int librarianChoice = scanner.nextInt();
                                scanner.nextLine();
                                switch (librarianChoice) {
                                    case 1:
                                        System.out.print("Enter Book Name: ");
                                        String bookName = scanner.nextLine();
                                        librarian.searchBook(library, bookName);
                                        break;
                                    case 2:
                                        System.out.print("Enter Member ID: ");
                                        long memberId = scanner.nextLong();
                                        scanner.nextLine();
                                        librarian.verifyMember(library, memberId);
                                        break;
                                    case 3:
                                        System.out.print("Enter Book ID: ");
                                        long bookId = scanner.nextLong();
                                        System.out.print("Enter Member ID: ");
                                        memId = scanner.nextLong();
                                        librarian.issueBook(library, bookId, memId);
                                        break;
                                    case 4:
                                        System.out.print("Enter Book ID: ");
                                        long returnBookId = scanner.nextLong();
                                        System.out.print("Enter Member ID: ");
                                        long returnMemberId = scanner.nextLong();
                                        librarian.returnBook(library, returnBookId, returnMemberId);
                                        break;
                                    case 5:
                                        librarian.calculateFine();
                                        break;
                                    case 6:


                                        System.out.println(library.getReaders());
                                        break;
                                    case 7:
                                        librarianExit = true;
                                        break;
                                    default:
                                        System.out.println("Invalid Choice");
                                }
                            }
                        }

                        System.out.println("Invalid librarian credentials.");
                        break;
                    case 2:
                        System.out.print("Enter category to list (JOURNALS,STUDYBOOKS,MAGAZINES): ");
                        String listCategoryInput = scanner.nextLine();
                        Edition listCategory = Edition.valueOf(listCategoryInput.toUpperCase());
                        List<Book> booksByCategory = library.listBooksByCategory(listCategory);
                        if (!booksByCategory.isEmpty()) {
                            Iterator var39 = booksByCategory.iterator();

                            while(true) {
                                if (!var39.hasNext()) {
                                    continue label110;
                                }

                                Book b = (Book)var39.next();
                                System.out.println(b);
                            }
                        }

                        System.out.println("No books found in this category.");
                        break;
                    case 3:
                        System.out.print("Enter author name to list books: ");
                        String listAuthor = scanner.nextLine();
                        List<Book> booksByAuthor = library.findBooksByAuthor(listAuthor);
                        if (!booksByAuthor.isEmpty()) {
                            Iterator var42 = booksByAuthor.iterator();

                            while(true) {
                                if (!var42.hasNext()) {
                                    continue label110;
                                }

                                Book b = (Book)var42.next();
                                System.out.println(b);
                            }
                        }

                        System.out.println("No books found by this author.");
                        break;
                    case 4:
                        System.out.println("All books in library");
                    case 5:
                        System.out.print("Enter Reader Name: ");
                        String readerName = scanner.nextLine();
                        Reader reader = (Reader)library.getReaders().stream().filter((r) -> {
                            return r.getName().equalsIgnoreCase(readerName);
                        }).findFirst().orElse((Reader)null);
                        if (reader == null) {
                            System.out.println("Reader not found. Creating a new reader...");
                            reader = new Reader(readerName, new ArrayList(), library);
                            library.addReader(reader);
                            System.out.println("Reader created and added to the library.");
                        }

                        System.out.print("Enter Book ID to borrow: ");
                        memId = scanner.nextLong();
                        scanner.nextLine();
                        Book book = library.findBookById(memId);
                        if (book != null) {
                            if (book.isStatus()) {
                                library.lendBook(book, reader);
                                System.out.println("Book borrowed successfully.");
                            } else {
                                System.out.println("Book is currently borrowed by " + book.getBorrowedBy().getName());
                            }
                        } else {
                            System.out.println("Book does not exist.");
                        }
                        break;
                    case 6:
                        System.out.print("Enter Reader Name: ");
                        String returnReaderName = scanner.nextLine();
                        Reader returnReader = (Reader)library.getReaders().stream().filter((r) -> {
                            return r.getName().equalsIgnoreCase(returnReaderName);
                        }).findFirst().orElse((Reader) null);
                        if (returnReader == null) {
                            System.out.println("Reader not found.");
                        } else {
                            System.out.print("Enter Book ID to return: ");
                            long bookIdToReturn = scanner.nextLong();
                            scanner.nextLine();
                            Book bookToReturn = library.findBookById(bookIdToReturn);
                            if (bookToReturn != null && !bookToReturn.isStatus()) {
                                library.takeBackBook(bookToReturn, returnReader);
                                System.out.println("Book returned successfully.");
                                continue;
                            }

                            System.out.println("Book is not currently borrowed or does not exist.");
                        }
                        break;
                    case 7:
                        System.out.println("Enter book ID:");
                        long book_ID = scanner.nextLong();
                        scanner.nextLine();
                        System.out.println("Enter Author name:");
                        String author = scanner.nextLine();
                        System.out.println("Enter book name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter book price:");
                        int price = scanner.nextInt();
                        scanner.nextLine();
                        Edition edition = null;
                        boolean validEdition = false;

                        while(!validEdition) {
                            System.out.println("Enter book category (JOURNALS, STUDYBOOKS, MAGAZINES):");
                            String categoryInput = scanner.nextLine().toUpperCase();

                            try {
                                edition = Edition.valueOf(categoryInput);
                                validEdition = true;
                            } catch (IllegalArgumentException var35) {
                                System.out.println("Invalid category. Please enter a valid category.");
                            }
                        }

                        library.addBook(new Book(book_ID, author, name, price, true, edition, new Date()));
                        break;
                    case 8:
                        System.out.println("Enter book ID to update: ");
                        long updateId = scanner.nextLong();
                        Book bookToUpdate = library.findBookById(updateId);
                        if (bookToUpdate != null) {
                            scanner.nextLine();
                            System.out.println("Enter Author name:");
                            bookToUpdate.setAuthor(scanner.nextLine());
                            System.out.println("Enter book name:");
                            bookToUpdate.setName(scanner.nextLine());
                            System.out.println("Enter book price:");
                            bookToUpdate.setPrice(scanner.nextInt());
                            System.out.println("Book updated.");
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;
                    case 9:
                        System.out.println("Enter book ID to delete:  ");
                        long deleteID = scanner.nextLong();
                        library.removeBook(deleteID);
                        System.out.println("Book removed from library.");
                        break;
                    case 10:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

            scanner.close();
            return;
        }
    }
}
