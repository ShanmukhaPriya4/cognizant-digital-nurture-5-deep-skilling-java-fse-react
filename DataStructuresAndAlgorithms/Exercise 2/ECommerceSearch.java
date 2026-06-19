class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Product Name: " + productName +
               ", Category: " + category;
    }
}

public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int key) {
        for (Product product : products) {
            if (product.productId == key) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int key) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == key) {
                return products[mid];
            } else if (products[mid].productId < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Sorted array by Product ID
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mouse", "Electronics"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "Headphones", "Accessories"),
            new Product(105, "Printer", "Office")
        };

        int searchId = 104;

        System.out.println("Linear Search:");
        Product result1 = linearSearch(products, searchId);
        if (result1 != null)
            System.out.println(result1);
        else
            System.out.println("Product Not Found");

        System.out.println("\nBinary Search:");
        Product result2 = binarySearch(products, searchId);
        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Product Not Found");
    }
}
