package dealership_workshop;

import java.util.ArrayList;

import static dealership_workshop.Car_Dealership.printAllVehicles;
import static dealership_workshop.Dealership_File_Manager.createInventoryFile;
import static dealership_workshop.Dealership_File_Manager.fileName;

public class Program {
//will be responsible for starting the application via its main()
//method and then creating the user interface and getting it started

    public static void main(String[] args) {
        createInventoryFile();
        ArrayList<Vehicle> inventory = new ArrayList<>();
        printAllVehicles(inventory);
    }
}
