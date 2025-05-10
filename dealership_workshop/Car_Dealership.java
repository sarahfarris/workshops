package dealership_workshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Car_Dealership {

    // be able to search by different properties within file
    // list all cars from file
    // add and remove cars

    // will hold info about the dealership (name, address) and maintain a list of vehicles. since it has a list of vehicles, it will also have the methods that search the list for matching vehicles as well as add/remove vehicles

     String name;
     String address;
     String phoneNr;
     ArrayList<Vehicle> inventory; //just the declaration, not instantiation
     static Scanner scanner;

    public static ArrayList<User_Interface> dealerships = new ArrayList<User_Interface>(); // list of dealerships where they will contain their own list of vehicles


    // the array list is now part of the parameter, removed it for now: , ArrayList<Vehicle> inventory
    public Car_Dealership(String name, String address, String phoneNr) {
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.inventory = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

     Car_Dealership(String line) {
        String[] fields = line.split("\\|");
        name = fields[0];
        address = fields[1];
        phoneNr = fields[2];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(name).append(" | ").append(address).append(" | ").append(phoneNr);
        return sb.toString();
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNr() {
        return phoneNr;
    }


    public Vehicle getVehiclesByPrice(double min, double max) {
//         inventory; I don't think I need this
        // create user input variables for min price and max price, and make it a range to search through
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getPrice() == vehicle.price) {
                System.out.println(vehicle);
            }
        }
        return null;
    }


    public ArrayList<Vehicle> getVehiclesByMake(String make) {
//        ArrayList<Vehicle> inventory;
        //create user input variables that searches by make and model, similar to how we did it in ledgerApp for search by vendor
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make)) {
                System.out.println(vehicle);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByModel(String model) {
//        ArrayList<Vehicle> inventory;
        //create user input variables that searches by make and model, similar to how we did it in ledgerApp for search by vendor
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getModel().equalsIgnoreCase(model)) {
                System.out.println(vehicle);
                //should i print result? do I even need a print statement here?
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                System.out.println(vehicle);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int year) {
//        ArrayList<Vehicle> inventory;
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getYear() == year) {
                System.out.println(vehicle);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
//        ArrayList<Vehicle> inventory;
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                System.out.println(vehicle);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(double odometer) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getOdometer() == odometer) {
                System.out.println(vehicle);
            }
        }
        return result;
    }


    //method to add a vehicle to the inventory of THIS dealership
    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
//        return null; changing this return since we are adding void, and added this.inventory
    }

    //method to remove a vehicle from the inventory of THIS dealership
    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }


    public static ArrayList<Vehicle> getAllVehicles(String fileName) {
        ArrayList<Vehicle> inventory = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                Vehicle vehicle = new Vehicle(line);
                inventory.add(vehicle);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error!");
            throw new RuntimeException(e);
        }
        return inventory;
    }

    public static ArrayList<Vehicle> readAllVehicles(String fileName) {
        printAllVehicles(getAllVehicles(fileName));
        return null;
    }

    public static void printAllVehicles(ArrayList<Vehicle> fileName) {
        if (fileName.isEmpty()) {
            System.out.println("No vehicles found!");
            return;
        }
        for (Vehicle vehicle : fileName) {
            System.out.println(vehicle);
        }
    }
}
