package V3;

public class ZurichStockExchange implements StockExchange {
    @Override
    public double getPrice(String symbol) {
        // In a real scenario, prices would be fetched from a live source.
        // Here we hardcode some example prices (in CHF).
        switch (symbol.toUpperCase()) {
            case "MSFT": return 90.0;    // Microsoft in Zurich
            case "AAPL": return 150.0;   // Apple in Zurich
            case "GOOG": return 2500.0;  // Google in Zurich
            default: return 0.0;
        }
    }
}

