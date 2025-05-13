package dealership_workshop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import static javax.print.attribute.standard.MediaSizeName.C;

public class Dealership_File_Manager {

  static String fileName = "src/main/resources/inventory.csv";

  public static Car_Dealership getDealership() {
    Car_Dealership dealership = null;
    try (BufferedReader br =
        new BufferedReader(new FileReader("inventory.csv"))) { // this is try with resources
      String[] dealershipString = br.readLine().split("\\|"); //this is the part I need to study
      dealership =
          new Car_Dealership(dealershipString[0], dealershipString[1], dealershipString[2]);
      String line;
      while ((line = br.readLine()) != null) {
        String[] vehicleString = line.split("\\|");
        Vehicle vehicle =
            new Vehicle(
                vehicleString[0],
                Integer.parseInt(vehicleString[1].trim()), //added trim to remove the spaces
                vehicleString[2],
                vehicleString[3],
                vehicleString[4],
                vehicleString[5],
                Double.parseDouble(vehicleString[6]), Double.parseDouble(vehicleString[7]));
        dealership.getInventory().add(vehicle);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return dealership;
  }

  public static void saveDealership(Car_Dealership dealership) {
    try (FileWriter fileWriter = new FileWriter("inventory.csv")) {
      fileWriter.write(dealership.toFileString());
      for (Vehicle vehicle : dealership.getInventory()) {
        fileWriter.write("\n" + vehicle.toFileString());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // method to create the original data file
  static void createInventoryFile() {
    File inventory = new File(fileName); // pathway to file
    BufferedWriter bw;
    Scanner scanner = new Scanner(System.in); // used to add to file, maybe make new method

    try {
      if (inventory.exists()) {
        bw = new BufferedWriter(new FileWriter(inventory, true));
        System.out.println("File exists, adding to file.");
      } else {
        bw = new BufferedWriter(new FileWriter(inventory));
      }
    } catch (IOException e) {
      System.out.println("Error loading vehicle inventory");
      createBackupFile(fileName);
      throw new RuntimeException(e);
    }
    // suggestion from intelliJ to add try/catch around bw.close()
    try {
      bw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // method to create backup data file
  public static void createBackupFile(String backupFileName) {
    Path sourcePath = Paths.get(fileName);
    Path backupPath =
        Paths.get(
            backupFileName); // suggestion from intelliJ and google, need to know more about what
                             // this does
    try {
      Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
      System.out.println("Backup file created.");
    } catch (IOException e) {
      System.out.println("Error backing up file:" + e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
