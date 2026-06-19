import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    // Update stock price
    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;

        System.out.println("\nStock Updated:");
        System.out.println(stockName + " = Rs." + price);

        notifyObservers();
    }
}

// Concrete Observer - Mobile App
class MobileApp implements Observer {

    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile App: " + stockName +
                " price updated to Rs." + price);
    }
}

// Concrete Observer - Web App
class WebApp implements Observer {

    @Override
    public void update(String stockName, double price) {
        System.out.println("Web App: " + stockName +
                " price updated to Rs." + price);
    }
}

// Main Class
public class ObserverPatternExample {

    public static void main(String[] args) {

        // Create Stock Market
        StockMarket stockMarket = new StockMarket();

        // Create Observers
        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        // Register Observers
        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        // Change Stock Prices
        stockMarket.setStockPrice("TCS", 3850.50);

        stockMarket.setStockPrice("Infosys", 1620.75);

        // Remove Mobile App
        stockMarket.removeObserver(mobile);

        System.out.println("\nAfter Removing Mobile App:");

        stockMarket.setStockPrice("Wipro", 280.40);
    }
}
