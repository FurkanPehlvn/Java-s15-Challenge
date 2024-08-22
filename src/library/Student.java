//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package library;

import java.util.Date;

public class Student extends MemberRecord {
    public Student(long member_ID, Type type, Date dateOfMembership, int booksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        super(member_ID, type, dateOfMembership, booksIssued, maxBookLimit, name, address, phoneNo);
    }

    public String toString() {
        return "Student{booksIssued=" + this.booksIssued + ", maxBookLimit=" + this.maxBookLimit + "}";
    }

    public void displayMemberInfo() {
    }

    public void payBill() {
    }

    public Reader getReader() {
        return null;
    }
}
