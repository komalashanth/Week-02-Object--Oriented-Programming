class Book {
    private final String isbn;
    private String title;
    private String author;

    static String libraryName = "Central Library";

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Library Name: " + libraryName);
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public static void main(String[] args) {
        Book b1 = new Book("ISBN101", "Java Programming", "James Gosling");
        Book b2 = new Book("ISBN102", "Clean Code", "Robert C. Martin");

        b1.displayBookDetails();
        System.out.println();
        b2.displayBookDetails();
        System.out.println();

        Book.displayLibraryName();
    }
}

``

