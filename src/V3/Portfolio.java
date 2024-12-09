package V3;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Stock> stocks;

    public Portfolio() {
        this.stocks = new ArrayList<>();
    }

    public void addStock(String symbol, int quantity) {
        this.stocks.add(new Stock(symbol, quantity));
    }

    /**
     * Calculate the total value of the portfolio given a stock exchange.
     */
    public double getTotalValue(StockExchange stockExchange) {
        double total = 0.0;
        for (Stock stock : stocks) {
            double price = stockExchange.getPrice(stock.getSymbol());
            total += price * stock.getQuantity();
        }
        return total;
    }

    /**
     * Prints the value of each stock in the given stock exchange.
     */
    public void printIndividualStockValues(StockExchange stockExchange) {
        for (Stock stock : stocks) {
            double price = stockExchange.getPrice(stock.getSymbol());
            System.out.println(stock.getSymbol() + ": " + price + " per share");
        }
    }
}

