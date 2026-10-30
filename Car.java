package rentalsystem;

public class Car extends Vehicle implements Maintainable {

    private int seats;
    private String transmissionType;

    public Car(String vehicleId,
               String brand,
               String model,
               int year,
               double dailyRentalPrice,
               int seats,
               String transmissionType) {

        super(vehicleId, brand, model, year, dailyRentalPrice);

        this.seats = seats;
        this.transmissionType = transmissionType;
    }

    @Override
    public double calculateRentalCost(int days) {

        return (getDailyRentalPrice() * days)
                + (15 * days);
    }

    @Override
    public void displayInfo() {

        System.out.println("Car ID: " + getVehicleId());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Seats: " + seats);
        System.out.println("Transmission: " + transmissionType);
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