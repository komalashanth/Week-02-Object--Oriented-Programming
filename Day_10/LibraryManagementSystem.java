interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    abstract int getLoanDuration();
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;

    Book(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    @Override
    int getLoanDuration() {
        return 14; // Books can be borrowed for 14 days
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            System.out.println("The book has been reserved.");
            isAvailable = false;
        } else {
            System.out.println("Sorry, the book is not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable;

    Magazine(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    @Override
    int getLoanDuration() {
        return 7; // Magazines can be borrowed for 7 days
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            System.out.println("The magazine has been reserved.");
            isAvailable = false;
        } else {
            System.out.println("Sorry, the magazine is not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;

    DVD(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    @Override
    int getLoanDuration() {
        return 5; // DVDs can be borrowed for 5 days
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            System.out.println("The DVD has been reserved.");
            isAvailable = false;
        } else {
            System.out.println("Sorry, the DVD is not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = new LibraryItem[3];
        items[0] = new Book("B123", "Java Programming", "John Doe", true);
        items[1] = new Magazine("M456", "Tech World", "Jane Smith", true);
        items[2] = new DVD("D789", "Inception", "Christopher Nolan", false);

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                if (reservableItem.checkAvailability()) {
                    reservableItem.reserveItem();
                } else {
                    System.out.println("Item not available for reservation.");
                }
            }
            
            System.out.println();
        }
    }
}

