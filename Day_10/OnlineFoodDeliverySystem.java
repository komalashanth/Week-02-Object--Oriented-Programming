interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Item: $" + price);
        System.out.println("Quantity: " + quantity);
    }

    abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    private double discountPercentage;

    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: " + discountPercentage + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discountPercentage;
    private static final double NON_VEG_EXTRA_CHARGES = 2.0;  // Additional charge for non-veg items

    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        return (getPrice() + NON_VEG_EXTRA_CHARGES) * getQuantity();
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: " + discountPercentage + "% (Includes extra charge for non-veg items)";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] orderItems = new FoodItem[4];
        orderItems[0] = new VegItem("Vegetable Pizza", 12.5, 2);
        orderItems[1] = new NonVegItem("Chicken Burger", 8.0, 3);
        orderItems[2] = new VegItem("Salad", 5.0, 1);
        orderItems[3] = new NonVegItem("Fish Tacos", 7.0, 2);

        for (FoodItem item : orderItems) {
            item.getItemDetails();
            System.out.println("Total Price: $" + item.calculateTotalPrice());

            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                discountableItem.applyDiscount(10);  // Apply a 10% discount
                System.out.println(discountableItem.getDiscountDetails());
            }

            System.out.println();
        }
    }
}

