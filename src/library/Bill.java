package library;

public class Bill {
    private Reader reader;
    private Book book;
    private int amount;
    private boolean paid;

    public Bill(Reader reader, Book book, int amount, boolean paid) {
        this.reader = reader;
        this.book = book;
        this.amount = amount;
        this.paid = false;
    }

    public void pay() {
        this.paid = true;
        System.out.println("Bill paid for book: " + this.book.getTitle());
    }

    public void refund() {
        if (this.paid) {
            System.out.println("Refund issued for book: " + this.book.getTitle());
        } else {
            System.out.println("Invoice has not been paid yet.");
        }

    }

    public String toString() {
        String var10000 = String.valueOf(this.reader);
        return "Bill{Reader=" + var10000 + ", book=" + String.valueOf(this.book) + ", amount=" + this.amount + ", paid=" + this.paid + "}";
    }
}
