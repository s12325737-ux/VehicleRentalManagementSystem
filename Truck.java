package rentalsystem;

public class Truck extends Vehicle implements Maintainable {

    private double maxLoadCapacity;

    public Truck(String vehicleId,
                 String brand,
                 String model,
                 int year,
                 double dailyRentalPrice,
                 double maxLoadCapacity) {

        super(vehicleId, brand, model, year, dailyRentalPrice);

        this.maxLoadCapacity = maxLoadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {

        return (getDailyRentalPrice() * days) + 50;
    }

    @Override
    public void displayInfo() {

        System.out.println("Truck ID: " + getVehicleId());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Max Load: " + maxLoadCapacity);
    }

    @Override
    public void performMaintenance() {

        maintenanceRequired = false;

        System.out.println("Truck maintenance completed.");
    }

    @Override
    public boolean needsMaintenance() {

        return maintenanceRequired;
    }
}