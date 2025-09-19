import java.util.*;

public class party {
    String partyid;
    String partyNumber;
    String partyName;
    String partyType;
    String partyGroup;
    String partyStatus;
    List<Map<String, String>> addresses = new ArrayList<>();
    List<Map<String, String>> communications = new ArrayList<>();

    public static void main(String[] args) {
        party P = new party();
        P.partyid = "P1234";
        P.partyNumber = "CUST0001";
        P.partyName = "Acme Corp";
        P.partyType = "Organization";
        P.partyGroup = "Customer";
        P.partyStatus = "Active";

        Map<String, String> billTo = new HashMap<>();
        billTo.put("PartyAddressID", "A1001");
        billTo.put("AddressType", "Bill_To");
        billTo.put("AddressLine1", "123 Billing St");
        billTo.put("AddressLine2", "Suite 100");
        billTo.put("City", "New York");
        billTo.put("State", "NY");
        billTo.put("Country", "USA");
        billTo.put("PostalCode", "10001");
        P.addresses.add(billTo);

        Map<String, String> shipTo = new HashMap<>();
        shipTo.put("PartyAddressID", "A1002");
        shipTo.put("AddressType", "Ship_To");
        shipTo.put("AddressLine1", "456 Shipping Ave");
        shipTo.put("AddressLine2", "");
        shipTo.put("City", "New York");
        shipTo.put("State", "NY");
        shipTo.put("Country", "USA");
        shipTo.put("PostalCode", "10002");
        P.addresses.add(shipTo);

        Map<String, String> phone = new HashMap<>();
        phone.put("ContactType", "Phone");
        phone.put("Contact", "123-456-7890");
        P.communications.add(phone);

        Map<String, String> email = new HashMap<>();
        email.put("ContactType", "Email");
        email.put("Contact", "contact@acme.com");
        P.communications.add(email);

        System.out.println("Party Name: " + P.partyName);
        System.out.println("Addresses:");
        for (Map<String, String> addr : P.addresses) {
            System.out.println(addr.get("AddressType") + ": " + addr.get("AddressLine1") + ", " + addr.get("City"));
        }
        System.out.println("Communications:");
        for (Map<String, String> comm : P.communications) {
            System.out.println(comm.get("ContactType") + " - " + comm.get("Contact"));
        }
    }

    public void UNUSEDfunction() {
        // does nothing
    }

    public void printPartyDetals() { // syntax error: typo in method name
        System.out.println("Party: " + partyName);
    }

    public static void staticMethod() { // unused static method
        System.out.println("Static method");
    }
}
