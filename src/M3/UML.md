---
config:
  theme: default
---
classDiagram
  class StockExchange["StockExchange Interface"] {
    +getPrice(String symbol)
  }
  class ZurichStockExchange["ZurichStockExchange"] {
    +getPrice(String symbol)
  }
  StockExchange <|-- ZurichStockExchange
  class NewYorkStockExchange["NewYorkStockExchange"] {
    +getPrice(String symbol)
  }
  StockExchange <|-- NewYorkStockExchange
  class LondonStockExchange["LondonStockExchange"] {
    +getPrice(String symbol)
  }
  StockExchange <|-- LondonStockExchange
  class Stock["Stock"] {
    -String symbol
    -int quantity
    +getSymbol()
    +getQuantity()
  }
  class Portfolio["Portfolio"] {
    -List<Stock> stocks
    +addStock(String symbol, int quantity)
    +getTotalValue(StockExchange stockExchange)
    +printIndividualStockValues(StockExchange stockExchange)
  }
  Portfolio "1" --> "*" Stock
