import java.util.*;

public class UserManager {

    private static List<String> userList = new ArrayList<>();
    private static Map<String, String> userDetails = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            String username = "user" + i;
            userList.add(username);
            userDetails.put(username, "User" + i + "@example.com");
        }

        printAllUserEmails();

        long start = System.currentTimeMillis();
        String targetUser = "user7863";
        boolean found = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(targetUser)) {
                System.out.println("Found user: " + targetUser);
                System.out.println("Email: " + userDetails.get(targetUser));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("User not found.");
        }

        long end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + " ms");

        bubbleSort(userList);

        removeUser("user5000");
    }

    public static void printAllUserEmails() {
        for (Map.Entry<String, String> entry : userDetails.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void bubbleSort(List<String> list) {
        int n = list.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    public static void removeUser(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(username)) {
                userList.remove(i);
                userDetails.remove(username);
                System.out.println(username + " removed");
                return;
            }
        }
        System.out.println(username + " not found");
    }
}
