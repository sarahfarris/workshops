package dealership_workshop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.print.attribute.standard.MediaSizeName.C;

public class Dealership_File_Manager {
    //this will manage the files that contain cars
    // ill be responsible for reading the dealership file,
    //parsing the data, and creating a Dealership object full of vehicles from the
    //file. It will also be responsible for saving a dealership and the vehicles back
    //into the file in the same pipe-delimited format
    BufferedWriter bw = new BufferedWriter(new FileWriter("inventory.csv"));
    static String fileName = "inventory.csv";

    public Dealership_File_Manager() throws IOException {
    }
    public String readLine() throws IOException {
        return readLine(false, null);
    }

    public Car_Dealership getDealership(String fileName){
        //should load and read inventory file
        ArrayList<Vehicle> inventory = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));
            String line;
            while ((line = br.readLine()) != null){
                Car_Dealership dealership = new Car_Dealership(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void saveDealership(Car_Dealership dealership){
        //don't write anything in here yet, this method will overwrite the inventory.csv file with the current dealership info and inventory list
    }
    //method to create the original data file
    static void createInventoryFile(){
        File inventory = new File(fileName); //pathway to file
        BufferedWriter bw;
        Scanner scanner = new Scanner(System.in); //used to add to file, maybe make new method

        try {
            if (inventory.exists()) {
                bw = new BufferedWriter(new FileWriter(inventory, true));
                System.out.println("File exists, adding to file.");
            } else {
                bw = new BufferedWriter(new FileWriter (inventory));
            }
        } catch (IOException e) {
            System.out.println("Error loading vehicle inventory");
            throw new RuntimeException(e);
        }
        //suggestion from intelliJ to add try/catch around bw.close()
        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //method to create backup data file
    public static void createBackupFile(String fileName, String backupFileName){
        Path sourcePath = Paths.get(fileName);
        Path backupPath = Paths.get(backupFileName);
        try {
            Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup file created.");
        } catch (IOException e) {
            System.out.println("Error backing up file:" + e.getMessage());
            throw new RuntimeException(e);
        }
        }





    }

