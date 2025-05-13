package dealership_workshop;

import java.util.ArrayList;


import static dealership_workshop.Dealership_File_Manager.createInventoryFile;
import static dealership_workshop.Dealership_File_Manager.fileName;


public class Program extends User_Interface{


    public static void main(String[] args) {
       User_Interface userInterface = new User_Interface(); //why do we create an object out of UI
       userInterface.display();
    }
}
