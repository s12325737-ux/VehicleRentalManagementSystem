package rentalsystem;

public abstract class Vehicle {

    private String vehicleId;
    private String brand;
    private String model;
    private int year;
    private double dailyRentalPrice;

    private boolean available;

    protected boolean maintenanceRequired;

    public Vehicle(String vehicleId,
                   String brand,
                   String model,
                   int year,
                   double dailyRentalPrice) {

        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyRentalPrice = dailyRentalPrice;

        this.available = true;
        this.maintenanceRequired = false;
    }

    public abstract double calculateRentalCost(int days);

    public abstract void displayInfo();

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isMaintenanceRequired() {
        return maintenanceRequired;
    }

    public void setMaintenanceRequired(boolean maintenanceRequired) {
        this.maintenanceRequired = maintenanceRequired;
    }
}