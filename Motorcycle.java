package rentalsystem;

public class Motorcycle extends Vehicle implements Maintainable {

    private int engineCapacity;
    private boolean helmetIncluded;

    public Motorcycle(String vehicleId,
                      String brand,
                      String model,
                      int year,
                      double dailyRentalPrice,
                      int engineCapacity,
                      boolean helmetIncluded) {

        super(vehicleId, brand, model, year, dailyRentalPrice);

        this.engineCapacity = engineCapacity;
        this.helmetIncluded = helmetIncluded;
    }

    @Override
    public double calculateRentalCost(int days) {

        return (getDailyRentalPrice() * days)
                + (5 * days);
    }

    @Override
    public void displayInfo() {

        System.out.println("Motorcycle ID: " + getVehicleId());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Engine Capacity: " + engineCapacity);
    }

    @Override
    public void performMaintenance() {

        maintenanceRequired = false;

        System.out.println("Maintenance completed.");
    }

    @Override
    public boolean needsMaintenance() {

        return maintenanceRequired;
    }
}