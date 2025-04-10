class Product {
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    static double discount = 10.0; // in percentage

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop", 750.0, 2);
        Product p2 = new Product(2, "Headphones", 50.0, 5);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
        System.out.println();

        System.out.println("Updating Discount to 15%...\n");
        Product.updateDiscount(15.0);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
    }
}

