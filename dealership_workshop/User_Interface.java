package dealership_workshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static dealership_workshop.Car_Dealership.*;
import static dealership_workshop.Dealership_File_Manager.fileName;

public class User_Interface {
    // this class will contain methods that will display menu, and search functions (getByVehicleType, etc)

    //this class will call on methods in the dealership class

    // responsible for all output to the screen, reading user input, and "dispatching" of the commands to the dealership as needed.  (ex: when the user selects "List all Vehicles", UserInterface would

    //call the appropriate Dealership method and then display the vehicles it
    //returns
    String car_dealership;


    public void userInterface() {
        //put menu in here
    }

    public void display(Car_Dealership car_dealership) {
        //not sure what to put in here
        init();
        String user_input = scanner.nextLine();
        System.out.println("==============\n Pick your Dealership ==============");
        System.out.println("1. Add");

    }

    //method to initialize the dealership - loads data, called by display()
    private void init() {
        //loads the dealership info
        this.car_dealership = "D & B Used Cars | 111 Old Benbrook Rd | 817-555-5555";
        Car_Dealership.dealerships.add(this);

        //load inventory
        Car_Dealership.dealerships.add(new Vehicle("126583129743 | 2017 | Ford | Fusion | Sedan | Grey | 86234"));
        //replace (new Vehicle("ford")) with "this"?
//        fileName.add(new Vehicle("126583129743 | 2017 | Ford | Fusion | Sedan | Grey | 86234")); dont know if I need this line
        System.out.println("Dealership " + this.car_dealership + " initialized");
    }

    //helper method as advised by the workbook
    //what should I name the parameter?
    private void displayVehicles(ArrayList<Vehicle> vehicleArrayList) {
        //displays the list and can be called from all the getVehicles type methods, should include a parameter that is passed in containing the vehicles to list, create a loop and display the vehicles
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                Vehicle vehicle = new Vehicle(line);
                vehicles.add(vehicle);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error!");
            throw new RuntimeException(e);
        }
    }


    public void processGetByPrice() {

    }

    public void processGetByMakeModel() {

    }

    public void processGetByYear() {

    }

    public void processGetByColor() {

    }

    public void processGetByMileage() {

    }

    public void processGetByVehicleType() {

    }

    public void processGetAllVehicles() {
        //list all vehicles in a dealership
        //1. call the dealership's getAllVehicles() 2. call displayVehicles() helper method passing it the list returned from getAllVehicles()
        getAllVehicles(fileName);
        displayVehicles(readAllVehicles(fileName));
    }

    public void processAddVehicle(Vehicle vehicle) {
        //get user input, create vehicle and add to inventory
    }

    public void processRemoveVehicle(Vehicle vehicle) {
        //get user input, create vehicle? and remove it
    }

}
