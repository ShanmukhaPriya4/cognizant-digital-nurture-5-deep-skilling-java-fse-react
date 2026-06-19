import java.util.HashMap;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               "\nProduct Name: " + productName +
               "\nQuantity: " + quantity +
               "\nPrice: " + price;
    }
}

public class InventoryManagementSystem {

    HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product Added Successfully.");
    }

    // Update Product
    public void updateProduct(int productId, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product Updated Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    // Delete Product
    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product Deleted Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    // Display Inventory
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty.");
            return;
        }

        for (Product product : inventory.values()) {
            System.out.println("------------------------");
            System.out.println(product);
        }
    }

    public static void main(String[] args) {

        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Add Products
        ims.addProduct(new Product(101, "Laptop", 20, 55000));
        ims.addProduct(new Product(102, "Mouse", 100, 500));
        ims.addProduct(new Product(103, "Keyboard", 50, 1200));

        System.out.println("\nInventory:");
        ims.displayInventory();

        // Update Product
        System.out.println("\nUpdating Product...");
        ims.updateProduct(102, 150, 450);

        // Delete Product
        System.out.println("\nDeleting Product...");
        ims.deleteProduct(103);

        System.out.println("\nFinal Inventory:");
        ims.displayInventory();
    }
}