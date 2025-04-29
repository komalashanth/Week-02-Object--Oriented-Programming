class Item {
    int itemCode;
    String itemName;
    double price;

    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

public class Inventory {
    public static void main(String[] args) {
        Item item = new Item(101, "Laptop", 750.50);
        item.displayDetails();
        int quantity = 3;
        System.out.println("Total Cost for " + quantity + " items: $" + item.calculateTotalCost(quantity));
    }
}

