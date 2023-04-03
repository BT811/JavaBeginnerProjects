import java.util.Scanner;

public class UserLogin {
    public UserLogin() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("User name:");
        String userName = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();
        if (userName.equals("username") && password.equals("1234512345")) {
            System.out.println("LOGIN SUCCESSFUL!!!");
        } else {
            System.out.println("Wrong username or password...");
        }

    }
}