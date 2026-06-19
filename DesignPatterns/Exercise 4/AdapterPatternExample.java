// Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee Class 1
class PayPalGateway {

    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using PayPal.");
    }
}

// Adaptee Class 2
class StripeGateway {

    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using Stripe.");
    }
}

// Adaptee Class 3
class RazorpayGateway {

    public void sendPayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using Razorpay.");
    }
}

// Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

// Adapter for Stripe
class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

// Adapter for Razorpay
class RazorpayAdapter implements PaymentProcessor {

    private RazorpayGateway razorpay;

    public RazorpayAdapter(RazorpayGateway razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public void processPayment(double amount) {
        razorpay.sendPayment(amount);
    }
}

// Main Class
public class AdapterPatternExample {

    public static void main(String[] args) {

        // PayPal Payment
        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(1500);

        // Stripe Payment
        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());
        stripe.processPayment(2500);

        // Razorpay Payment
        PaymentProcessor razorpay =
                new RazorpayAdapter(new RazorpayGateway());
        razorpay.processPayment(3500);
    }
}
