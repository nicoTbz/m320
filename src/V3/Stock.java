package V3;

public class Stock {
    private String symbol;
    private int quantity;

    public Stock(String symbol, int quantity) {
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }
}
