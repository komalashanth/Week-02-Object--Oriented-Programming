interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }

    abstract double calculateFare(double distance);
}

class Car extends Vehicle {
    Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Bike extends Vehicle {
    Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Auto extends Vehicle {
    Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Ride implements GPS {
    private String location;

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }

    public void calculateAndDisplayFare(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        double fare = vehicle.calculateFare(distance);
        System.out.println("Total Fare: $" + fare);
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle car = new Car("C123", "John Doe", 2.5);
        Vehicle bike = new Bike("B456", "Jane Smith", 1.5);
        Vehicle auto = new Auto("A789", "Bob Brown", 1.0);

        Ride ride = new Ride();
        ride.updateLocation("Downtown");
        System.out.println("Current Location: " + ride.getCurrentLocation());

        System.out.println("\nCalculating Fare for Car (10 km):");
        ride.calculateAndDisplayFare(car, 10);

        System.out.println("\nCalculating Fare for Bike (5 km):");
        ride.calculateAndDisplayFare(bike, 5);

        System.out.println("\nCalculating Fare for Auto (8 km):");
        ride.calculateAndDisplayFare(auto, 8);
    }
}

