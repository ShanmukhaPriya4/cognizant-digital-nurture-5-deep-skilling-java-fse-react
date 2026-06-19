// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy - Credit Card
class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}

// Concrete Strategy - PayPal
class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal.");
    }
}

// Context Class
class PaymentContext {

    private PaymentStrategy paymentStrategy;

    // Set Strategy
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute Strategy
    public void makePayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("No payment method selected.");
        }
    }
}

// Main Class
public class StrategyPatternExample {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Use Credit Card Payment
        context.setPaymentStrategy(new CreditCardPayment());
        context.makePayment(1500);

        // Change to PayPal Payment
        context.setPaymentStrategy(new PayPalPayment());
        context.makePayment(2500);
    }
}
