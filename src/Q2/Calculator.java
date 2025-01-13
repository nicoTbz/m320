package Q2;

/**
 * The Calculator class provides basic arithmetic operations such as
 * addition, subtraction, multiplication, and division.
 */
public class Calculator {

    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts one number from another.
     *
     * @param a the number to subtract from
     * @param b the number to subtract
     * @return the result of a minus b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the product of a and b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides one number by another.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the result of a divided by b
     * @throws ArithmeticException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed!");
            return 0;
        }
        return a / b;
    }
}
