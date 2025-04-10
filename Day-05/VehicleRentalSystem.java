interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    abstract double calculateRentalCost(int days);

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
}

class Car extends Vehicle implements Insurable {
    private double insuranceRate;

    Car(String vehicleNumber, double rentalRate, double insuranceRate) {
        super(vehicleNumber, "Car", rentalRate);
        this.insuranceRate = insuranceRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Car Insurance Rate: " + insuranceRate * 100 + "%");
    }
}

class Bike extends Vehicle implements Insurable {
    private double insuranceRate;

    Bike(String vehicleNumber, double rentalRate, double insuranceRate) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insuranceRate = insuranceRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Bike Insurance Rate: " + insuranceRate * 100 + "%");
    }
}

class Truck extends Vehicle implements Insurable {
    private double insuranceRate;

    Truck(String vehicleNumber, double rentalRate, double insuranceRate) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insuranceRate = insuranceRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Truck Insurance Rate: " + insuranceRate * 100 + "%");
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("C123", 100, 0.05);
        vehicles[1] = new Bike("B456", 50, 0.03);
        vehicles[2] = new Truck("T789", 200, 0.07);

        int rentalDays = 5;

        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Vehicle: " + vehicle.getType());
            System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
            System.out.println("Rental Cost for " + rentalDays + " days: $" + rentalCost);

            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                double insuranceCost = insurableVehicle.calculateInsurance();
                System.out.println("Insurance Cost: $" + insuranceCost);
                insurableVehicle.getInsuranceDetails();
            }

            System.out.println();
        }
    }
}
