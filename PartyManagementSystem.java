import java.util.*;

public class partymanagementsystem {

    static int partyIdCounter = 1;
    static int addressIdCounter = 1;

    public static void main(String[] args) {

        Party party1 = new Party("John Doe", "Individual", "Customer", "Active");
        party1.addAddress(new Address("Billing", "123 Elm St", "Suite 5", "Springfield", "IL", "USA", "62701"));
        party1.addAddress(new Address("Shipping", "456 Oak St", "", "Springfield", "IL", "USA", "62701"));
        party1.addCommunication(new Communication("Email", "john.doe@example.com"));
        party1.addCommunication(new Communication("Phone", "+1-217-555-1234"));
        System.out.println(party1);

        Party party2 = new Party("Acme Corp", "Organization", "Vendor", "Active");
        party2.addAddress(new Address("Billing", "789 Maple Ave", "", "Chicago", "IL", "USA", "60601"));
        party2.addAddress(new Address("Shipping", "321 Pine St", "", "Chicago", "IL", "USA", "60601"));
        party2.addCommunication(new Communication("Fax", "+1-312-555-5678"));
        party2.addCommunication(new Communication("Email", "contact@acmecorp.com"));
        System.out.println(party2);
    }
}

class Party {
    int partyId;
    String partyNumber;
    String name;
    String type;
    String group;
    String status;

    List<Address> addresses = new ArrayList<>();
    List<Communication> communications = new ArrayList<>();

    Party(String name, String type, String group, String status) {
        this.partyId = PartyManagementSystem.partyIdCounter++;
        this.partyNumber = generateNumber(group);
        this.name = name;
        this.type = type;
        this.group = group;
        this.status = status;
    }

    String generateNumber(String group) {
        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }
        return group + "_" + System.nanoTime();
    }

    void addAddress(Address address) {
        addresses.add(address);
    }

    void addCommunication(Communication communication) {
        communications.add(communication);
    }

    public String toString() {
        return "Party{id:" + partyId + ", number:" + partyNumber + ", name:" + name + ", type:" + type + ", group:" + group + ", status:" + status + ", addresses:" + addresses + ", communications:" + communications + "}";
    }
}

class Address {
    int addressId;
    String addressType;
    String line1;
    String line2;
    String city;
    String state;
    String country;
    String postalCode;

    Address(String addressType, String line1, String line2, String city, String state, String country, String postalCode) {
        this.addressId = PartyManagementSystem.addressIdCounter++;
        this.addressType = addressType;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String toString() {
        return "Address{id:" + addressId + ", type:" + addressType + ", line1:" + line1 + ", line2:" + line2 + ", city:" + city + ", state:" + state + ", country:" + country + ", postalCode:" + postalCode + "}";
    }
}

class Communication {
    String contactType;
    String contact;

    Communication(String contactType, String contact) {
        this.contactType = contactType;
        this.contact = contact;
        if (!isValid(contactType, contact)) {
            throw new IllegalArgumentException("Invalid contact: " + contactType);
        }
    }

    boolean isValid(String type, String contact) {
        if (type.equalsIgnoreCase("email")) {
            return contact.matches("[\\w.-]+@[\\w.-]+\\.\\w{2,}");
        } else if (type.equalsIgnoreCase("phone") || type.equalsIgnoreCase("fax")) {
            return contact.matches("\\+?[0-9\\- ]{7,15}");
        } else {
            return false;
        }
    }

    public String toString() {
        return "Communication{type:" + contactType + ", contact:" + contact + "}";
    }
}
