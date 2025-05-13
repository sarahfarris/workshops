package dealership_workshop;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Car_Dealership {

  private String name;
  private String address;
  private String phoneNr;

  private List<Vehicle> inventory = new ArrayList<>(); // just the declaration, not instantiation

  public Car_Dealership(String name, String address, String phoneNr) {
    this.name = name;
    this.address = address;
    this.phoneNr = phoneNr;
  }

  Car_Dealership(String line) {
    String[] fields = line.split("\\|");
    name = fields[0];
    address = fields[1];
    phoneNr = fields[2];
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNr() {
    return phoneNr;
  }

  public void setPhoneNr(String phoneNr) {
    this.phoneNr = phoneNr;
  }

  public List<Vehicle> getInventory() {
    return inventory;
  }

  public List<Vehicle> getVehiclesByPrice(double min, double max) {
    List<Vehicle> matchingVehicles = new ArrayList<>(); //initialize list of vehicles that match the arguments
    for (Vehicle vehicle : inventory) {
      if (vehicle.getPrice() <= max && vehicle.getPrice() >= min) {
        matchingVehicles.add(vehicle);
      }
    }
    return matchingVehicles;
  }

  public List<Vehicle> getVehiclesByMakeAndModel(String make, String model) {
    List<Vehicle> matchingVehicles = new ArrayList<>();
    for (Vehicle vehicle : inventory) {
      if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getMake().equalsIgnoreCase(model)) {
        matchingVehicles.add(vehicle);
      }
    }
    return matchingVehicles;
  }

  public List<Vehicle> getVehiclesByYear(int min, int max) {
    List<Vehicle> matchingVehicles = new ArrayList<>();
    for (Vehicle vehicle : inventory) {
      if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
        matchingVehicles.add(vehicle);
      }
    }
    return matchingVehicles;
  }

  public List<Vehicle> getVehiclesByColor(String color) {
    List<Vehicle> matchingVehicles = new ArrayList<>();
    for (Vehicle vehicle : this.inventory) {
      if (vehicle.getColor().equalsIgnoreCase(color)) {
        matchingVehicles.add(vehicle);
      }
    }
    return matchingVehicles;
  }

  public List<Vehicle> getVehiclesByMileage(double min, double max) {
    List<Vehicle> matchingVehicles = new ArrayList<>();
    for (Vehicle vehicle : this.inventory) {
      if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
        matchingVehicles.add(vehicle);
      }
    }
    return matchingVehicles;
  }
  public List<Vehicle> getVehiclesByType(String vehicleType) {
    List<Vehicle> matchingVehicles = new ArrayList<>();
    for (Vehicle vehicle : inventory) {
      if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
        matchingVehicles.add(vehicle);
      }
    }
    return matchingVehicles;
  }

  // method to add a vehicle to the inventory of THIS dealership
  public void addVehicle(Vehicle vehicle) {
    inventory.add(vehicle);
    Dealership_File_Manager.saveDealership(this);
  }

  // method to remove a vehicle from the inventory of THIS dealership
  public void removeVehicle(Vehicle vehicle) {
    inventory.remove(vehicle);
    Dealership_File_Manager.saveDealership(this);
  }

  public List<Vehicle> getAllVehicles() {
    return inventory;
  }

  public String toFileString() {
    return name + " | " + address + " | " + phoneNr;
  }
}
