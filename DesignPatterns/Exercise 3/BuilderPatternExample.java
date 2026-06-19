public class BuilderPatternExample {

    // Product Class
    static class Computer {

        // Attributes
        private String CPU;
        private String RAM;
        private String Storage;
        private String GraphicsCard;
        private String OperatingSystem;

        // Private Constructor
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
            this.GraphicsCard = builder.GraphicsCard;
            this.OperatingSystem = builder.OperatingSystem;
        }

        // Display Computer Configuration
        public void display() {
            System.out.println("Computer Configuration:");
            System.out.println("CPU              : " + CPU);
            System.out.println("RAM              : " + RAM);
            System.out.println("Storage          : " + Storage);
            System.out.println("Graphics Card    : " + GraphicsCard);
            System.out.println("Operating System : " + OperatingSystem);
            System.out.println("-----------------------------------");
        }

        // Static Nested Builder Class
        static class Builder {

            private String CPU;
            private String RAM;
            private String Storage;
            private String GraphicsCard;
            private String OperatingSystem;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String Storage) {
                this.Storage = Storage;
                return this;
            }

            public Builder setGraphicsCard(String GraphicsCard) {
                this.GraphicsCard = GraphicsCard;
                return this;
            }

            public Builder setOperatingSystem(String OperatingSystem) {
                this.OperatingSystem = OperatingSystem;
                return this;
            }

            // Build Method
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Main Method
    public static void main(String[] args) {

        // Gaming Computer
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32 GB")
                .setStorage("1 TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        // Office Computer
        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16 GB")
                .setStorage("512 GB SSD")
                .setOperatingSystem("Windows 10")
                .build();

        // Student Computer
        Computer studentPC = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM("8 GB")
                .setStorage("256 GB SSD")
                .build();

        // Display Configurations
        gamingPC.display();
        officePC.display();
        studentPC.display();
    }
}
