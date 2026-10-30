package rentalsystem;


public class Rental {

    private String rentalId;
    private Customer customer;
    private Vehicle vehicle;

    private int rentalDays;

    private double totalCost;

    private String status;

    public Rental(String rentalId,
                  Customer customer,
                  Vehicle vehicle,
                  int rentalDays) {

        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;

        totalCost =
                vehicle.calculateRentalCost(rentalDays);

        status = "Active";
    }

    public String getRentalId() {
        return rentalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void completeRental() {

        status = "Completed";

        vehicle.setAvailable(true);
    }

    public void displayRentalInfo() {

        System.out.println("Rental ID: "
                + rentalId);

        System.out.println("Customer: "
                + customer.getFullName());

        System.out.println("Vehicle: "
                + vehicle.getVehicleId());

        System.out.println("Days: "
                + rentalDays);

        System.out.println("Cost: "
                + totalCost);

        System.out.println("Status: "
                + status);
    }
}