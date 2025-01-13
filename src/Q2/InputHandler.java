package Q2;

import java.util.Scanner;

/**
 * The InputHandler class manages user input and validates numerical
 * and operator inputs for the calculator.
 */
public class InputHandler {
    private Scanner scanner;

    /**
     * Constructs an InputHandler with a provided Scanner.
     *
     * @param scanner the Scanner used for reading user input
     */
    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Prompts the user to enter a number and validates the input.
     * Allows the user to exit the program by typing "exit".
     *
     * @param prompt the message shown to the user
     * @return the entered number as a double
     */
    public double getNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                System.exit(0);
            }

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please try again.");
            }
        }
    }

    /**
     * Prompts the user to enter a valid arithmetic operator.
     * Allows the user to exit the program by typing "exit".
     *
     * @param prompt the message shown to the user
     * @return the entered operator as a String (+, -, *, /)
     */
    public String getOperator(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                System.exit(0);
            }

            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                return input;
            } else {
                System.out.println("Invalid operator, please enter one of (+, -, *, /).");
            }
        }
    }
}
