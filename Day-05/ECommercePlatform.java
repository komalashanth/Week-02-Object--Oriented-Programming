interface Taxable {
    double calculateTax();
    void getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Electronics extends Product implements Taxable {
    private double discountRate;

    Electronics(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax rate for Electronics: 18%");
    }
}

class Clothing extends Product implements Taxable {
    private double discountRate;

    Clothing(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12;
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax rate for Clothing: 12%");
    }
}

class Groceries extends Product {
    Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return 0;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Electronics(101, "Laptop", 50000, 0.1);
        products[1] = new Clothing(102, "T-shirt", 1000, 0.15);
        products[2] = new Groceries(103, "Apple", 150);

        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = 0;
            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                tax = taxableProduct.calculateTax();
                taxableProduct.getTaxDetails();
            }
            double finalPrice = product.getPrice() + tax - discount;
            System.out.println("Product: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Discount: -$" + discount);
            System.out.println("Tax: +$" + tax);
            System.out.println("Final Price: $" + finalPrice);
            System.out.println();
        }
    }
}

