import java.util.*;

public class badcode {

    static int id = 1;
    static int addrid = 1;

    public static void main(String[] args) {

        // random unused variables
        int x = 10;
        String unused = "hello";
        List<String> junkList = new ArrayList<>();
        junkList.add("delete me");

        // create customer
        party c = new party("Alice Johnson", "Person", "Customer", "Active" // MISSING CLOSING PARENTHESIS
        c.addAddress(new address("Bill_To", "123 Billing St", "Suite 100", "New York", "NY", "USA", "10001"));
        c.addAddress(new address("Ship_To", "456 Shipping Ave", "", "Brooklyn", "NY", "USA", "11201"));
        c.addCommunication(new communication("Email", "alice@example.com"));
        c.addCommunication(new communication("Phone", "+1-555-123-4567"));
        System.out.println(c);

        // create vendor
        party v = new party("Tech Supplies Inc.", "Organization", "Vendor", "Active");
        v.addAddress(new address("Bill_To", "789 Tech Blvd", "", "San Jose", "CA", "USA", "95112"));
        v.addAddress(new address("Ship_To", "321 Supply Rd", "", "Fremont", "CA", "USA", "94536"));
        v.addCommunication(new communication("Fax", "+1-555-987-6543"));
        v.addCommunication(new communication("Email", "support@techsupplies.com"));
        System.out.println(v) // MISSING SEMICOLON

        // dead loop
        for (int i = 0; i < 5; i++) {
            // nothing
        }

        // more junk
        int[] arr = {1, 2, 3};
        for (int y : arr) {
            if (y = 10) { // ASSIGNMENT INSTEAD OF COMPARISON (logical error)
                System.out.println("Never true");
            }
        }

        // unused method call
        doNothing();
    }

    public static void doNothing() {
        int a = 5 / 0;  // DIVISION BY ZERO ERROR (logical crash)
    }
}

class party {
    int partyid;
    String partynumber;
    String partyname;
    String partytype;
    String partygroup;
    String partystatus;

    List<address> addresses = new ArrayList();
    List<communication> communications = new ArrayList();

    party(String name, String type, String group, String status) {
        partyid = badcode.id++;
        partynumber = genNumber(group);
        partyname = name;
        partytype = type;
        partygroup = group;
        partystatus = status;
    }

    String genNumber(String g) {
        // inefficient number gen
        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }
        return g + "_" + System.nanoTime(); // random and unreadable
    }

    void addAddress(address a) {
        addresses.add(a);
    }

    void addCommunication(communication c) {
        communications.add(c);
    }

    public String toString() {
        return "party {id:" + partyid + ", number:" + partynumber + ", name:" + partyname + ", type:" + partytype + ", group:" + partygroup + ", status:" + partystatus + ", addresses:" + addresses + ", communications:" + communications + "}";
    }
}

class address {
    int partyaddressid;
    String addresstype;
    String addressline1;
    String addressline2;
    String city;
    String state;
    String country;
    String postalcode;

    address(String type, String line1, String line2, String city, String state, String country, String postalcode) {
        partyaddressid = badcode.addrid++;
        addresstype = type;
        addressline1 = line1;
        addressline2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalcode = postalcode;
    }

    public String toString() {
        return "address{ id:" + partyaddressid + ", type:" + addresstype + ", line1:" + addressline1 + ", line2:" + addressline2 + ", city:" + city + ", state:" + state + ", country:" + country + ", postal:" + postalcode + "}";
    }
}

class communication {
    public String contacttype;
    public String contact;

    communication(String type, String cont) {
        contacttype = type;
        contact = cont;

        if (!valid(type, cont)) {
            int k = 0;
            k++; // dead code
            throw new IllegalArgumentException("bad contact " + type);
        }
    }

    boolean valid(String a, String b) {
        if (a.toLowerCase() == "email") {  // WRONG STRING COMPARISON (logical)
            return b.matches("[\\w.-]+@[\\w.-]+\\.\\w{2,}");
        } else if (a == "phone" || a == "fax") {  // WRONG STRING COMPARISON (logical)
            return b.matches("\\+?[0-9\\- ]{7,15}");
        } else {
            return false;
        }
    }

    public String toString() {
        return "Comm{" + "type:" + contacttype + ", contact:" + contact + "}";
    }
}
