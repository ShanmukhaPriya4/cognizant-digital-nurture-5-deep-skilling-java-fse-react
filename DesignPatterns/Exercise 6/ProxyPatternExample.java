// Subject Interface
interface Image {
    void display();
}

// Real Subject
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    // Simulate loading image from remote server
    private void loadFromServer() {
        System.out.println("Loading image from remote server: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// Proxy Class
class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {

        // Lazy Initialization
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        // Cached object is reused
        realImage.display();
    }
}

// Main Class
public class ProxyPatternExample {

    public static void main(String[] args) {

        Image image = new ProxyImage("nature.jpg");

        System.out.println("First Display:");
        image.display();

        System.out.println();

        System.out.println("Second Display:");
        image.display();
    }
}
