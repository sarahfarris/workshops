package dealership_workshop;

class Vehicle extends User_Interface {
    // will hold info about a specific vehicle\
    //will hold getters and setters for every field
    int vin;
    int year;
    String make;
    String model;
    String vehicleType;
    String color;
    int odometer;
    double price;

     public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }
      Vehicle(String line){
        String[] fields = line.split("\\|");
        vin = Integer.parseInt(fields[0]);
        year = Integer.parseInt(fields[1]);
        make = fields[2];
        model = fields[3];
        vehicleType = fields[4];
        color = fields[5];
        odometer = Integer.parseInt(fields[6]);
        price = Double.parseDouble(fields[7]);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append(vin)
                .append(" | ")
                .append(year)
                .append(" | ")
                .append(make)
                .append(" | ")
                .append(model)
                .append(" | ")
                .append(vehicleType)
                .append(" | ")
                .append(color)
                .append(" | ")
                .append(odometer);
        return sb.toString();
    }

    public int getVin() {
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

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }
}
