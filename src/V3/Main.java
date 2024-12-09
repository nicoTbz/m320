package V3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a portfolio and add some stocks
        Portfolio portfolio = new Portfolio();
        portfolio.addStock("MSFT", 10);
        portfolio.addStock("AAPL", 5);
        portfolio.addStock("GOOG", 2);

        // Prepare our stock exchanges
        StockExchange zurich = new ZurichStockExchange();
        StockExchange newYork = new NewYorkStockExchange();
        StockExchange london = new LondonStockExchange();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Stock Portfolio Interface ---");
            System.out.println("1: Set Stock Market (Zurich)");
            System.out.println("2: Set Stock Market (New York)");
            System.out.println("3: Set Stock Market (London)");
            System.out.println("4: Show individual stock prices");
            System.out.println("5: Show total portfolio value");
            System.out.println("6: Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            StockExchange selectedExchange = null;

            if (choice == 6) {
                running = false;
                continue;
            }

            // For choices 1-5, we need to have an exchange selected.
            // Let the user choose the market first if they haven't yet.
            // We'll store the chosen market until changed.
            switch (choice) {
                case 1: selectedExchange = zurich; break;
                case 2: selectedExchange = newYork; break;
                case 3: selectedExchange = london; break;
                case 4:
                case 5:
                    System.out.println("Currently selected stock market?");
                    System.out.println("1: Zurich");
                    System.out.println("2: New York");
                    System.out.println("3: London");
                    System.out.print("Choose market: ");
                    int marketChoice = scanner.nextInt();
                    if (marketChoice == 1) {
                        selectedExchange = zurich;
                    } else if (marketChoice == 2) {
                        selectedExchange = newYork;
                    } else if (marketChoice == 3) {
                        selectedExchange = london;
                    } else {
                        System.out.println("Invalid market choice.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            // Execute actions based on the original menu choice
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.println("Market changed successfully.");
                    break;
                case 4:
                    // Show individual stock prices
                    System.out.println("\nIndividual stock prices:");
                    portfolio.printIndividualStockValues(selectedExchange);
                    break;
                case 5:
                    // Show total portfolio value
                    double totalValue = portfolio.getTotalValue(selectedExchange);
                    System.out.println("\nTotal Portfolio Value: " + totalValue);
                    break;
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}

