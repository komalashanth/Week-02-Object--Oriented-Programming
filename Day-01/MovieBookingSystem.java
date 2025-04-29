class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    boolean isBooked;

    public MovieTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false;
    }

    public void bookTicket() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Seat already booked.");
        }
    }

    public void displayTicketDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);
        System.out.println("Booking Status: " + (isBooked ? "Booked" : "Available"));
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Avengers: Endgame", 12, 15.99);
        ticket.displayTicketDetails();
        ticket.bookTicket();
        ticket.displayTicketDetails();
    }
}

