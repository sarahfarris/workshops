package dealership_workshop;

import java.util.List;
import java.util.Scanner;

public class User_Interface {
  private Car_Dealership dealership;
  private static Scanner scanner = new Scanner(System.in);

  public User_Interface() {
    // put menu in here
  }

  private void init() {
    // loads the dealership info
    this.dealership =
        Dealership_File_Manager.getDealership(); // calling the dealership object declared above
  }

  public void display() {
    init(); // call on the initialization of the dealership object
    boolean keepGoing = true;
    while (keepGoing) {
      displayMenu();
      keepGoing = processUserChoice(Integer.parseInt(scanner.nextLine()));
    }
    System.out.println("Thank you for using our app. Exiting...");
  }

  public static void displayMenu() {
    String menu =
        """
                    1) Find vehicles within a price range
                    2) Find vehicles by make/model
                    3) Find vehicles by year range
                    4) Find vehicles by color
                    5) Find vehicles by mileage
                    6) Find vehicles by type
                    7) List ALL vehicles
                    8) Add vehicle
                    9) Remove vehicle
                    10) Quit""";
    System.out.println(menu);
  }

  public boolean processUserChoice(int choice) {
    switch (choice) {
      case 1:
        processGetByPrice();
        break;
      case 2:
        processGetByMakeModel();
        break;
      case 3:
        processGetByYear();
        break;
      case 4:
        processGetByColor();
        break;
      case 5:
        processGetByMileage();
        break;
      case 6:
        processGetByVehicleType();
        break;
      case 7:
        displayVehicles(dealership.getInventory());
        break;
      case 8:
        processAddVehicle();
        break;
      case 9:
        processRemoveVehicle();
        break;
      case 10:
        return false; // why do we say false
      default:
        System.out.println("Not a valid option");
    }
    return true; //why do we need this here
  }

  public void processGetByPrice() {
    System.out.println("What is the min price?");
    double min = Double.parseDouble(scanner.nextLine());
    System.out.println("What is the max price?");
    double max = Double.parseDouble(scanner.nextLine());
    displayVehicles(dealership.getVehiclesByPrice(min, max));
  }

  public void processGetByMakeModel() {
    System.out.println("What is the make?");
    String user_input = scanner.nextLine();
    System.out.println("What is the model?");
    String user_input2 = scanner.nextLine();
    displayVehicles(dealership.getVehiclesByMakeAndModel(user_input, user_input2));
  }

  public void processGetByYear() {
    System.out.println("What is the minimum year you would like to search through?");
    int user_input = scanner.nextInt();
    System.out.println("What is the maximum year you would like to search through?");
    int user_input2 = scanner.nextInt(); // the demo has it parsing into a string
    displayVehicles(dealership.getVehiclesByYear(user_input, user_input2));
  }

  public void processGetByColor() {
    System.out.println("Please enter the color you would like to search: ");
    String colorChoice = scanner.nextLine();
    displayVehicles(dealership.getVehiclesByColor(colorChoice));
  }

  public void processGetByMileage() {
    System.out.println("Enter the minimum mileage you would like to search by: ");
    double min = scanner.nextDouble();
    System.out.println("Enter the maximum mileage you would like to search by: ");
    double max = scanner.nextDouble();
    displayVehicles(dealership.getVehiclesByMileage(min, max));
  }

  public void processGetByVehicleType() {
    System.out.println("Enter the type of vehicle you would like to find: ");
    String vehicleType = scanner.nextLine();
    displayVehicles(dealership.getVehiclesByType(vehicleType));
  }

  public void processAddVehicle() {
    System.out.println("VIN: ");
    String vin = scanner.nextLine();
    System.out.println("Year: ");
    int year = scanner.nextInt();
    System.out.println("Make: ");
    String make = scanner.nextLine();
    System.out.println("Model: ");
    String model = scanner.nextLine();
    System.out.println("Vehicle type: ");
    String type = scanner.nextLine();
    System.out.println("Color: ");
    String color = scanner.nextLine();
    System.out.println("Odometer reading: ");
    double odometer = scanner.nextDouble();
    System.out.println("Price: ");
    double price = scanner.nextDouble();
    Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
    this.dealership.addVehicle(vehicle);
  }

  public void processRemoveVehicle() {
    System.out.println("Please enter the VIN of the vehicle you wish to remove: ");
    String vin = scanner.nextLine();
    Vehicle vehicle = new Vehicle(vin, 0, null, null, null, null, 0, 0);
    this.dealership.removeVehicle(vehicle);
  }

  private void displayVehicles(List<Vehicle> vehicleList) {
    for (Vehicle vehicle : vehicleList) {
      System.out.println(vehicle.toFileString());
    }
  }
}
