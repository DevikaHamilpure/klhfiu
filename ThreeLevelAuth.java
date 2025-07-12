import java.util.Scanner;
import java.util.Random;

public class ThreeLevelAuth {

    // Level 1: Username & Password
    static boolean levelOne(String username, String password) {
        return username.equals("admin") && password.equals("password123");
    }

    // Level 2: Security Question
    static boolean levelTwo(String answer) {
        return answer.equalsIgnoreCase("blue");
    }

    // Level 3: OTP verification
    static boolean levelThree(int generatedOtp, int enteredOtp) {
        return generatedOtp == enteredOtp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("====== Three-Level Authentication System ======");
        
        // Level 1
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (!levelOne(username, password)) {
            System.out.println("Authentication Failed at Level 1!");
            return;
        }
        System.out.println("Level 1 Authentication Successful.");

        // Level 2
        System.out.println("Security Question: What is your favorite color?");
        String answer = sc.nextLine();

        if (!levelTwo(answer)) {
            System.out.println("Authentication Failed at Level 2!");
            return;
        }
        System.out.println("Level 2 Authentication Successful.");

        // Level 3
        Random rand = new Random();
        int otp = 1000 + rand.nextInt(9000); // 4-digit OTP
        System.out.println("Your OTP is: " + otp); // simulate sending OTP
        System.out.print("Enter the OTP: ");
        int userOtp = sc.nextInt();

        if (!levelThree(otp, userOtp)) {
            System.out.println("Authentication Failed at Level 3!");
            return;
        }
        System.out.println("Level 3 Authentication Successful.");
        System.out.println("Access Granted!");
    }
}