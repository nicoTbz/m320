package V3;

public class LondonStockExchange implements StockExchange {
    @Override
    public double getPrice(String symbol) {
        // Hardcoded example prices (in GBP).
        switch (symbol.toUpperCase()) {
            case "MSFT": return 70.0;     // Microsoft in London
            case "AAPL": return 140.0;    // Apple in London
            case "GOOG": return 2300.0;   // Google in London
            default: return 0.0;
        }
    }
}
