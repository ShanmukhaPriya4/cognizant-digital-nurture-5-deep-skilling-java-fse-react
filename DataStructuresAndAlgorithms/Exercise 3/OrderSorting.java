class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
               ", Customer: " + customerName +
               ", Total Price: " + totalPrice;
    }
}

public class OrderSorting {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {

        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice <= pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void display(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {

        Order[] orders = {
                new Order(101, "Alice", 5500),
                new Order(102, "Bob", 2500),
                new Order(103, "Charlie", 7200),
                new Order(104, "David", 4100),
                new Order(105, "Emma", 9000)
        };

        // Bubble Sort
        Order[] bubbleOrders = orders.clone();

        System.out.println("Bubble Sort:");
        bubbleSort(bubbleOrders);
        display(bubbleOrders);

        // Quick Sort
        Order[] quickOrders = orders.clone();

        System.out.println("\nQuick Sort:");
        quickSort(quickOrders, 0, quickOrders.length - 1);
        display(quickOrders);
    }
}
