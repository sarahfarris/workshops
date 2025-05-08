package dealership_workshop;

import java.util.ArrayList;
import java.util.Scanner;

public class Car_Dealership {
    // create a file writer to input cars
    // be able to search by different properties within file
    // list all cars from file
    // add and remove cars
    // this class will contain getters for search functions
    // and add/remove cars to the file
    // will hold info about the dealership (name, address) and maintain a list of vehicles. since it has a list of vehicles, it will also have the methods that search the list for matching vehicles as well as add/remove vehicles
    //will need getters and setters for every field except inventory
    String name;
    String address;
    String phoneNr;

    ArrayList<Vehicle> inventory; //just the declaration, not instantiation
    // the array list is now part of the parameter
    public Car_Dealership(String name, String address, String phoneNr, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.inventory = new ArrayList<>(inventory);
    }
    public Car_Dealership(String line){
        String[] fields = line.split("\\|");
        name = fields[0];
        address = fields[1];
        phoneNr = fields[2];
    }

    //then if that is the case, do I need a toString() method here? I put it in the Vehicle class



    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPhoneNr(){
        return phoneNr;
    }

    public Vehicle getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> inventory;
        // create user input variables for min price and max price, and make it a range to search through
        return null;
    }
    public Vehicle getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> inventory;
        //create user input variables that searches by make and model, similar to how we did it in ledgerApp for search by vendor
        return null;
    }
    public Vehicle getVehiclesByYear(double min, double max){
        ArrayList<Vehicle> inventory;
        //create user input variables for min/max year, make it a range to search through
        return null;
    }
    public Vehicle getVehiclesByColor(String color){
        ArrayList<Vehicle> inventory;
        return null;
    }
    public Vehicle getVehiclesByMileage(double min, double max){
        ArrayList<Vehicle> inventory;
        return null;
    }
    public Vehicle getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> inventory;
        return null;
    }
    public Vehicle getAllVehicles(){
        ArrayList<Vehicle> inventory;
        return null;
    }
    public Vehicle addVehicle(){
        return null;
    }
    public Vehicle removeVehicle(){
        return null;
    }
}
