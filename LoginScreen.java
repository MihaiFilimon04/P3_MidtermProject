import java.util.Scanner;

public class LoginScreen {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "1234";

    public static boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid credentials. Try again.");
            return false;
        }
    }
}
