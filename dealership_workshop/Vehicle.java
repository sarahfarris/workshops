package dealership_workshop;

public class Vehicle {
    // will hold info about a specific vehicle\
    //will hold getters and setters for every field
    int vin;
    int year;
    String make;
    String model;
    String vehicleType;
    String color;
    int odometer;
    double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }
}
