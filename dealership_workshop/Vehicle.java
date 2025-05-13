package dealership_workshop;
import java.util.Objects; //why do we need this

class Vehicle extends User_Interface {
    private String vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private double odometer;
    private double price;

     public Vehicle(String vin, int year, String make, String model, String vehicleType, String color, double odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public double getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    public String toFileString() {
         return vin + " | " +  year + " | "  + make + " | " + model + " | " + vehicleType + " | " + color + " | " + odometer + " | " + price;
    }
    //I have no idea what any of this means
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vin, vehicle.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

}
