import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private static final Scanner scanner = new Scanner(System.in);

    // Method to print a message to the console
    public static void print(String message) {
        System.out.println(message);
    }

    // Method to ask a question and return the user's input as a String
    public static String askString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    // Method to ask a question and return the user's input as an integer
    public static int askInt(String question) {
        System.out.println(question);
        while (!scanner.hasNextInt()) {
            scanner.next(); // Read and discard non-integer input
            System.out.println("Please enter a valid integer.");
        }
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        return number;
    }

    // Method to ask a yes/no question and return the answer as a boolean
    public static boolean askYesNo(String question) {
        System.out.println(question + " (yes/no)");
        String answer = scanner.nextLine().trim().toLowerCase();
        while (!answer.equals("yes") && !answer.equals("no")) {
            System.out.println("Please answer 'yes' or 'no'.");
            answer = scanner.nextLine().trim().toLowerCase();
        }
        return answer.equals("yes");
    }

    // Method to print a list of items with indices
    public static void printListWithIndices(List<String> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    // Method to print a list of items with indices and scan for an integer answer
    public static int askForChoiceFromList(List<String> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("The list is empty.");
            return -1;
        }

        printListWithIndices(items);

        System.out.println("Enter the number of your choice: ");
        int choice = 0;

        // Validate the choice
        boolean validInput = false;
        while (!validInput) {
            try {
                choice = scanner.nextInt();
                // Validate the choice range
                if (choice < 1 || choice > items.size()) {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + items.size() + ".");
                } else {
                    validInput = true; // Valid input and within range, break the loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the incorrect input
            }
        }

        scanner.nextLine(); // Consume the newline character left after reading an integer

        return choice; // Return the user's choice
    }

    // Method to print a list of items with indices and scan for an integer answer, then return the text of the chosen item
    public static String askForChoiceFromListString(List<String> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("The list is empty.");
            return "Error";
        }

        printListWithIndices(items);

        System.out.println("Enter the number of your choice: ");
        int choice = 0;

        // Validate the choice
        boolean validInput = false;
        while (!validInput) {
            try {
                choice = scanner.nextInt();
                // Validate the choice range
                if (choice < 1 || choice > items.size()) {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + items.size() + ".");
                } else {
                    validInput = true; // Valid input and within range, break the loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the incorrect input
            }
        }

        String output = items.get(--choice);

        scanner.nextLine(); // Consume the newline character left after reading an integer

        return output; // Return the user's choice
    }
}
