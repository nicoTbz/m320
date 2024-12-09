package V3;

public class NewYorkStockExchange implements StockExchange {
    @Override
    public double getPrice(String symbol) {
        // Hardcoded example prices (in USD).
        switch (symbol.toUpperCase()) {
            case "MSFT": return 80.0;     // Microsoft in New York
            case "AAPL": return 145.0;    // Apple in New York
            case "GOOG": return 2400.0;   // Google in New York
            default: return 0.0;
        }
    }
}