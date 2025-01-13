package Q2;

import java.util.Scanner;

/**
 * The Main class serves as the entry point for the Simple Calculator program.
 * It handles user interaction and delegates calculations to the Calculator class.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        InputHandler inputHandler = new InputHandler(scanner);

        System.out.println("Simple Calculator");
        System.out.println("Available operations: +  -  *  /");
        System.out.println("Type 'exit' to quit the program");

        while (true) {
            double num1 = inputHandler.getNumber("Enter the first number: ");
            String operator = inputHandler.getOperator("Enter an operator (+, -, *, /): ");
            double num2 = inputHandler.getNumber("Enter the second number: ");

            double result;
            switch (operator) {
                case "+":
                    result = calculator.add(num1, num2);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operator!");
                    continue;
            }

            System.out.println("Result: " + result);
            System.out.println("----------------------------------");
        }
    }
}
