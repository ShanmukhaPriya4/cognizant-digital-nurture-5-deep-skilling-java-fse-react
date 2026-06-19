// Component Interface
interface Notifier {
    void send(String message);
}

// Concrete Component
class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}

// Abstract Decorator
abstract class NotifierDecorator implements Notifier {

    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete Decorator - SMS
class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("SMS Notification: " + message);
    }
}

// Concrete Decorator - Slack
class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Slack Notification: " + message);
    }
}

// Main Class
public class DecoratorPatternExample {

    public static void main(String[] args) {

        // Email only
        System.out.println("Email Only:");
        Notifier email = new EmailNotifier();
        email.send("Your order has been placed.");

        System.out.println();

        // Email + SMS
        System.out.println("Email + SMS:");
        Notifier emailSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailSMS.send("Your order has been shipped.");

        System.out.println();

        // Email + SMS + Slack
        System.out.println("Email + SMS + Slack:");
        Notifier allNotifications =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifications.send("Your order has been delivered.");
    }
}