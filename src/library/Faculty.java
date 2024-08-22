//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package library;

import java.util.Date;

public class Faculty extends MemberRecord {
    public Faculty(long member_ID, Type type, Date dateOfMembership, int booksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        super(member_ID, type, dateOfMembership, booksIssued, maxBookLimit, name, address, phoneNo);
    }

    public String toString() {
        return "Faculty{booksIssued=" + this.booksIssued + ", maxBookLimit=" + this.maxBookLimit + "}";
    }

    public Reader getReader() {
        return null;
    }

    public void displayMemberInfo() {
    }

    public void payBill() {
    }
}
