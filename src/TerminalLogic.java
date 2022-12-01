import java.util.Scanner;

public class TerminalLogic {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = ""; 

        System.out.println("Please enter Eco-time date in 'MM/DD' format (excluding quotations): ");
        input = scanner.nextLine();

        if (input.length() != 5) {
            // Minimal safe-guarding against wrong input.
            System.out.println("Incorrect date format. Please try again.");
            scanner.close();
            return;
        }
        else {
            // Assuming it's correct input
            Settings.date = input;
        }

        System.out.println("Clocking in time for '" + input + "' from " + Settings.inTime + " to " + Settings.outTime + ". Is this correct? (Y/n): ");
        input = scanner.nextLine();

        if (input.equals("Y") || input.equals("y")) {
            System.out.println("Initializing Selenium...");
            App.main();
        }
        else if (input.equals("exit")) {
            System.out.println("Exiting out...");
        }
        else { 
            System.out.println("If the above date is incorrect, please try");
            System.out.println("If the actual times are wrong, please edit Settings.java");
        }

        scanner.close();
    }
}
