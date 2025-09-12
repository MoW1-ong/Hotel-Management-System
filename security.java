
import java.util.ArrayList;
import java.util.Scanner;

public class Security {
    private static Scanner scanner = new Scanner(System.in);
    private String user_name;
    private String password;
    private String role; // "admin" or "user"
    private static ArrayList<Security> account = new ArrayList<>();

    // Default admin + user
    public Security() {
        new Security("admin", "admin123", "admin");
        new Security("user", "user123", "user");
    }

    public Security(String user_name, String password, String role) {
        this.user_name = user_name;
        this.password = password;
        this.role = role.toLowerCase();
        account.add(this);
    }

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return user_name;
    }

    private String getPassword() {
        return password;
    }

    public static Security login(String expectedRole) {
        System.out.println("\n=== " + expectedRole.toUpperCase() + " LOGIN ===");
        System.out.print("Username: ");
        String inputUser = scanner.nextLine();
        System.out.print("Password: ");
        String inputPass = scanner.nextLine();

        for (Security acc : account) {
            if (acc.getUserName().equals(inputUser)
                    && acc.getPassword().equals(inputPass)
                    && acc.getRole().equals(expectedRole)) {
                System.out.println("\nLogin successful! Welcome " + acc.getUserName());
                return acc;
            }
        }

        System.out.println("\nInvalid credentials for " + expectedRole + "!");
        return null;
    }
}
