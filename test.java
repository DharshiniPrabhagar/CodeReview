import java.util.*;
import java.io.*;

public class PartyManagementSystem {
    // Models for Guest, Party, RSVP, Expense
    static class Guest {
        int id;
        String name;
        String email;
        boolean vip;
        String phone;

        Guest(int id, String name, String email, String phone, boolean vip) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.vip = vip;
            this.phone = phone;
        }
    }
    static class Party {
        int id;
        String name;
        String date; // e.g., "2024-07-01"
        String venue;
        String description;
        List<Integer> invitedGuests;
        List<Expense> expenses;
        Party(int id, String name, String date, String venue, String description) {
            this.id = id;
            this.name = name;
            this.date = date;
            this.venue = venue;
            this.description = description;
            this.invitedGuests = new ArrayList<>();
            this.expenses = new ArrayList<>();
        }
    }
    static class RSVP {
        int guestId;
        int partyId;
        boolean attending;
        RSVP(int guestId, int partyId, boolean attending) {
            this.guestId = guestId;
            this.partyId = partyId;
            this.attending = attending;
        }
    }
    static class Expense {
        String item;
        double amount;
        Expense(String item, double amount) {
            this.item = item;
            this.amount = amount;
        }
    }

    // Data
    static Map<Integer, Guest> guests = new HashMap<>();
    static Map<Integer, Party> parties = new HashMap<>();
    static List<RSVP> rsvps = new ArrayList<>();
    static int guestIdSeq = 1;
    static int partyIdSeq = 1;

    // Main Loop
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Party Management System ===");
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Manage Guests");
            System.out.println("2. Manage Parties");
            System.out.println("3. RSVP Management");
            System.out.println("4. Expenses Management");
            System.out.println("5. Reports");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String ch = sc.nextLine();
            switch(ch) {
                case "1": guestMenu(sc); break;
                case "2": partyMenu(sc); break;
                case "3": rsvpMenu(sc); break;
                case "4": expenseMenu(sc); break;
                case "5": reportMenu(sc); break;
                case "0": 
                    System.out.println("Goodbye!"); 
                    return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // ========== GUEST MENU ==========
    static void guestMenu(Scanner sc) {
        while(true) {
            System.out.println("\n--- Guest Management ---");
            System.out.println("1. Add Guest");
            System.out.println("2. View Guests");
            System.out.println("3. Update Guest");
            System.out.println("4. Delete Guest");
            System.out.println("0. Back");
            System.out.print("Choose option: ");
            String ch = sc.nextLine();
            switch(ch) {
                case "1": addGuest(sc); break;
                case "2": viewGuests(); break;
                case "3": updateGuest(sc); break;
                case "4": deleteGuest(sc); break;
                case "0": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void addGuest(Scanner sc) {
        System.out.print("Guest name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Is VIP (y/n): ");
        boolean vip = sc.nextLine().equalsIgnoreCase("y");
        Guest g = new Guest(guestIdSeq++, name, email, phone, vip);
        guests.put(g.id, g);
        System.out.println("Guest added with ID " + g.id);
    }

    static void viewGuests() {
        System.out.println("--- Guest List ---");
        if (guests.isEmpty()) {
            System.out.println("No guests.");
            return;
        }
        for (Guest g : guests.values()) {
            System.out.printf("ID: %d | Name: %s | Email: %s | Phone: %s | VIP: %s\n", 
                g.id, g.name, g.email, g.phone, g.vip ? "Yes":"No");
        }
    }

    static void updateGuest(Scanner sc) {
        System.out.print("Enter Guest ID: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            Guest g = guests.get(id);
            if(g==null) { System.out.println("Not found."); return; }
            System.out.print("New name (" + g.name + "): ");
            String name = sc.nextLine();
            if(!name.isEmpty()) g.name = name;
            System.out.print("New email (" + g.email + "): ");
            String email = sc.nextLine();
            if(!email.isEmpty()) g.email = email;
            System.out.print("New phone ("+g.phone+"): ");
            String phone = sc.nextLine();
            if(!phone.isEmpty()) g.phone = phone;
            System.out.print("VIP (y/n): ");
            String vipStr = sc.nextLine();
            if(!vipStr.isEmpty()) g.vip = vipStr.equalsIgnoreCase("y");
            System.out.println("Guest updated.");
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }

    static void deleteGuest(Scanner sc) {
        System.out.print("Enter Guest ID to delete: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            if (guests.remove(id)!=null)
                System.out.println("Guest deleted.");
            else
                System.out.println("Guest not found.");
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }

    // ========== PARTY MENU ==========
    static void partyMenu(Scanner sc) {
        while(true) {
            System.out.println("\n--- Party Management ---");
            System.out.println("1. Create Party");
            System.out.println("2. View Parties");
            System.out.println("3. Update Party");
            System.out.println("4. Delete Party");
            System.out.println("5. Invite Guest to Party");
            System.out.println("6. Remove Guest from Party");
            System.out.println("7. View Party Guest List");
            System.out.println("0. Back");
            System.out.print("Choose option: ");
            String ch = sc.nextLine();
            switch(ch) {
                case "1": createParty(sc); break;
                case "2": viewParties(); break;
                case "3": updateParty(sc); break;
                case "4": deleteParty(sc); break;
                case "5": inviteGuestToParty(sc); break;
                case "6": removeGuestFromParty(sc); break;
                case "7": viewPartyGuestList(sc); break;
                case "0": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void createParty(Scanner sc) {
        System.out.print("Party Name: ");
        String name = sc.nextLine();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Venue: ");
        String venue = sc.nextLine();
        System.out.print("Description: ");
        String desc = sc.nextLine();
        Party p = new Party(partyIdSeq++, name, date, venue, desc);
        parties.put(p.id, p);
        System.out.println("Party created with ID " + p.id);
    }
    static void viewParties() {
        System.out.println("--- Parties List ---");
        if (parties.isEmpty()) {
            System.out.println("No parties.");
            return;
        }
        for(Party p : parties.values()) {
            System.out.printf("ID: %d | Name: %s | Date: %s | Venue: %s\n", 
                p.id, p.name, p.date, p.venue);
        }
    }
    static void updateParty(Scanner sc) {
        System.out.print("Enter Party ID: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            Party p = parties.get(id);
            if(p==null) { System.out.println("Not found."); return; }
            System.out.print("New name (" + p.name + "): ");
            String name = sc.nextLine();
            if(!name.isEmpty()) p.name = name;
            System.out.print("New date (" + p.date + "): ");
            String date = sc.nextLine();
            if(!date.isEmpty()) p.date = date;
            System.out.print("New venue (" + p.venue + "): ");
            String venue = sc.nextLine();
            if(!venue.isEmpty()) p.venue = venue;
            System.out.print("New Desc (" + p.description + "): ");
            String desc = sc.nextLine();
            if(!desc.isEmpty()) p.description = desc;
            System.out.println("Party updated.");
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void deleteParty(Scanner sc) {
        System.out.print("Enter Party ID to delete: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            if (parties.remove(id)!=null)
                System.out.println("Party deleted.");
            else
                System.out.println("Party not found.");
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void inviteGuestToParty(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            System.out.print("Guest ID: ");
            int gid = Integer.parseInt(sc.nextLine());
            if(!guests.containsKey(gid)) { System.out.println("Guest not found."); return;}
            if(p.invitedGuests.contains(gid)) {
                System.out.println("Already invited.");
            } else {
                p.invitedGuests.add(gid);
                System.out.println("Guest invited.");
            }
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void removeGuestFromParty(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            System.out.print("Guest ID: ");
            int gid = Integer.parseInt(sc.nextLine());
            if(p.invitedGuests.remove((Integer)gid)) {
                System.out.println("Removed.");
            } else {
                System.out.println("Not invited.");
            }
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void viewPartyGuestList(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            System.out.println("--- Invited Guests ---");
            for(int gid : p.invitedGuests) {
                Guest g = guests.get(gid);
                if(g!=null) {
                    System.out.printf("ID: %d | Name: %s | Email: %s | VIP: %s\n", g.id, g.name, g.email, g.vip?"Yes":"No");
                }
            }
            if(p.invitedGuests.isEmpty()) System.out.println("No guests invited.");
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }

    // ========== RSVP MENU ==========
    static void rsvpMenu(Scanner sc) {
        while(true) {
            System.out.println("\n--- RSVP Management ---");
            System.out.println("1. RSVP to a Party");
            System.out.println("2. View Party RSVPs");
            System.out.println("3. View Guest's RSVPs");
            System.out.println("4. Remove RSVP");
            System.out.println("0. Back");
            System.out.print("Choose option: ");
            String ch = sc.nextLine();
            switch(ch) {
                case "1": rsvpParty(sc); break;
                case "2": viewPartyRsvps(sc); break;
                case "3": viewGuestRsvps(sc); break;
                case "4": removeRsvp(sc); break;
                case "0": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    static void rsvpParty(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            System.out.print("Guest ID: ");
            int gid = Integer.parseInt(sc.nextLine());
            Guest g = guests.get(gid);
            if(g==null) { System.out.println("Guest not found."); return; }
            if(!p.invitedGuests.contains(gid)) {
                System.out.println("Guest not invited to this party.");
                return;
            }
            boolean attending = false;
            System.out.print("Attending? (y/n): ");
            attending = sc.nextLine().equalsIgnoreCase("y");
            boolean found = false;
            for(RSVP r : rsvps) {
                if(r.guestId==gid&&r.partyId==pid) {
                    r.attending = attending;
                    found = true;
                }
            }
            if(!found) rsvps.add(new RSVP(gid,pid,attending));
            System.out.println("RSVP " + (attending?"Yes":"No"));
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void viewPartyRsvps(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            System.out.println("--- Party RSVPs ---");
            for(RSVP r : rsvps) {
                if(r.partyId==pid) {
                    Guest g = guests.get(r.guestId);
                    if(g!=null) {
                        System.out.printf("Guest: %s (%s) | Attending: %s\n", g.name, g.email, r.attending?"Yes":"No");
                    }
                }
            }
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void viewGuestRsvps(Scanner sc) {
        System.out.print("Guest ID: ");
        try {
            int gid = Integer.parseInt(sc.nextLine());
            Guest g = guests.get(gid);
            if(g==null) { System.out.println("Guest not found."); return; }
            System.out.println("--- Guest RSVPs ---");
            for(RSVP r : rsvps) {
                if(r.guestId==gid) {
                    Party p = parties.get(r.partyId);
                    if(p!=null)
                        System.out.printf("Party: %s (%s) | Attending: %s\n", p.name, p.date, r.attending?"Yes":"No");
                }
            }
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void removeRsvp(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            System.out.print("Guest ID: ");
            int gid = Integer.parseInt(sc.nextLine());
            Iterator<RSVP> it = rsvps.iterator();
            boolean removed = false;
            while(it.hasNext()) {
                RSVP r = it.next();
                if(r.partyId==pid&&r.guestId==gid) {
                    it.remove();
                    removed = true;
                }
            }
            System.out.println(removed?"RSVP removed.":"RSVP not found.");
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }

    // ========== EXPENSE MENU ==========
    static void expenseMenu(Scanner sc) {
        while(true) {
            System.out.println("\n--- Expense Management ---");
            System.out.println("1. Add Expense to Party");
            System.out.println("2. View Party Expenses");
            System.out.println("3. Remove Expense");
            System.out.println("0. Back");
            System.out.print("Choose option: ");
            String ch = sc.nextLine();
            switch(ch) {
                case "1": addExpense(sc); break;
                case "2": viewPartyExpenses(sc); break;
                case "3": removeExpense(sc); break;
                case "0": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    static void addExpense(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            System.out.print("Expense Item: ");
            String item = sc.nextLine();
            System.out.print("Amount: ");
            double amt = Double.parseDouble(sc.nextLine());
            p.expenses.add(new Expense(item, amt));
            System.out.println("Expense added.");
        } catch(Exception e) { System.out.println("Failed. Enter valid data."); }
    }
    static void viewPartyExpenses(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            System.out.println("--- Party Expenses ---");
            double total=0;
            for(Expense e : p.expenses) {
                System.out.printf("%s : %.2f\n", e.item, e.amount);
                total+=e.amount;
            }
            System.out.printf("Total: %.2f\n", total);
            if(p.expenses.isEmpty()) System.out.println("No expenses logged.");
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void removeExpense(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            System.out.print("Expense Item to remove: ");
            String item = sc.nextLine();
            int count=0;
            Iterator<Expense> it = p.expenses.iterator();
            while(it.hasNext()) {
                Expense e = it.next();
                if(e.item.equalsIgnoreCase(item)) {
                    it.remove();
                    count++;
                }
            }
            System.out.println(count>0?("Removed "+count+" entries."):"No such expense.");
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }

    // ========== REPORTS MENU ==========
    static void reportMenu(Scanner sc) {
        while(true) {
            System.out.println("\n--- Reports ---");
            System.out.println("1. Party Attendance Report");
            System.out.println("2. VIP Guest List for Party");
            System.out.println("3. Total Expenses for Party");
            System.out.println("4. Guest Invites & Attendance Summary");
            System.out.println("0. Back");
            System.out.print("Choose option: ");
            String ch = sc.nextLine();
            switch(ch) {
                case "1": partyAttendanceReport(sc); break;
                case "2": vipGuestListReport(sc); break;
                case "3": totalExpensesReport(sc); break;
                case "4": guestSummaryReport(); break;
                case "0": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    static void partyAttendanceReport(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            int yes=0, no=0, pending=0;
            Set<Integer> responded = new HashSet<>();
            for(RSVP r : rsvps) {
                if(r.partyId==pid) {
                    if(r.attending) yes++; else no++;
                    responded.add(r.guestId);
                }
            }
            pending = p.invitedGuests.size() - responded.size();
            System.out.printf("Party '%s':\n", p.name);
            System.out.printf("Invited: %d\nYes: %d\nNo: %d\nPending: %d\n", p.invitedGuests.size(), yes, no, pending);
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void vipGuestListReport(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            System.out.println("--- VIP Guests for Party ---");
            int cnt=0;
            for(int gid : p.invitedGuests) {
                Guest g = guests.get(gid);
                if(g!=null && g.vip) {
                    System.out.printf("ID: %d | Name: %s | Email: %s\n", g.id, g.name, g.email);
                    cnt++;
                }
            }
            if(cnt==0) System.out.println("No VIP guests invited.");
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void totalExpensesReport(Scanner sc) {
        System.out.print("Party ID: ");
        try {
            int pid = Integer.parseInt(sc.nextLine());
            Party p = parties.get(pid);
            if(p==null) { System.out.println("Party not found."); return; }
            double total=0;
            for(Expense e : p.expenses) total+=e.amount;
            System.out.printf("Total expenses for '%s': %.2f\n", p.name, total);
        } catch(NumberFormatException e) { System.out.println("Invalid ID."); }
    }
    static void guestSummaryReport() {
        System.out.println("--- Guest Invites & Attendance ---");
        for(Guest g : guests.values()) {
            int invited=0, attended=0, no=0;
            for(Party p : parties.values()) {
                if(p.invitedGuests.contains(g.id)) invited++;
                for(RSVP r : rsvps) {
                    if(r.guestId==g.id && r.partyId==p.id) {
                        if(r.attending) attended++; else no++;
                    }
                }
            }
            System.out.printf("ID: %d | Name: %s | Invited: %d | Attended: %d | Declined: %d\n",
                g.id, g.name, invited, attended, no);
        }
    }
}
