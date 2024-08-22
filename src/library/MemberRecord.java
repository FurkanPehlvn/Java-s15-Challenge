//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package library;

import java.util.Date;
import java.util.Objects;

public abstract class MemberRecord {
    private long member_ID;
    private Type type;
    private Date dateOfMembership;
    protected int booksIssued;
    protected int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;
    private Person person;

    public MemberRecord(long member_ID, Type type, Date dateOfMembership, int booksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        this.member_ID = member_ID;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.booksIssued = booksIssued;
        this.maxBookLimit = 5;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public abstract Reader getReader();

    public long getMember_ID() {
        return this.member_ID;
    }

    public int getBooksIssued() {
        return this.booksIssued;
    }

    public int getMaxBookLimit() {
        return this.maxBookLimit;
    }

    public String getMemName() {
        return this.name;
    }

    public abstract void displayMemberInfo();

    public void incrementBooksIssued() {
        if (this.booksIssued < this.maxBookLimit) {
            ++this.booksIssued;
        } else {
            System.out.println("Cannot issue more books. Limit reached.");
        }

    }

    public void decrementBooksIssued() {
        if (this.booksIssued > 0) {
            --this.booksIssued;
        } else {
            System.out.println("No books to return.");
        }

    }

    public abstract void payBill();

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object != null && this.getClass() == object.getClass()) {
            MemberRecord that = (MemberRecord)object;
            return this.member_ID == that.member_ID;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.member_ID);
    }
}
