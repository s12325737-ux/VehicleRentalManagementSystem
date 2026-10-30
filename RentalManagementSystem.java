package rentalsystem;

import java.util.ArrayList;

public class RentalManagementSystem {

    private ArrayList<Vehicle> vehicles;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;

    public RentalManagementSystem() {

        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addRental(Rental rental) {

        rentals.add(rental);

        rental.getVehicle().setAvailable(false);
    }

    public void displayAllVehicles() {

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }

    public void displayAllCustomers() {

        for (Customer customer : customers) {
            customer.displayCustomerInfo();
        }
    }

    public void displayAllRentals() {

        for (Rental rental : rentals) {
            rental.displayRentalInfo();
        }
    }

    public Vehicle searchVehicle(String vehicleId) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }

        return null;
    }

    // Overloading
    public Vehicle searchVehicle(String brand,
                                 String model) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getBrand().equalsIgnoreCase(brand)
                    && vehicle.getModel().equalsIgnoreCase(model)) {

                return vehicle;
            }
        }

        return null;
    }

    public Customer searchCustomer(String customerId) {

        for (Customer customer : customers) {

            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }

        return null;
    }
    public void displayAvailableVehicles() {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.isAvailable()) {

                vehicle.displayInfo();
            }
        } 
    }
    public void returnVehicle(String rentalId) {

        for (Rental rental : rentals) {

            if (rental.getRentalId().equals(rentalId)
                    && rental.getStatus().equals("Active")) {

                rental.completeRental();

                System.out.println("Vehicle returned successfully.");

                return;
            }
        }

        System.out.println("Rental not found.");
    } 
    public double calculateRevenue() {

        double revenue = 0;

        for (Rental rental : rentals) {

            if (rental.getStatus().equals("Completed")) {

                revenue += rental.getTotalCost();
            }
        }

        return revenue;
    }
    public void displayCustomerRentalHistory(String customerId) {

        for (Rental rental : rentals) {

            if (rental.getCustomer()
                    .getCustomerId()
                    .equals(customerId)) {

                rental.displayRentalInfo();
            }
        }
    }
    public void flagVehicleForMaintenance(String vehicleId) {

        Vehicle vehicle = searchVehicle(vehicleId);

        if (vehicle != null) {

            vehicle.setMaintenanceRequired(true);

            System.out.println("Vehicle flagged for maintenance.");
        }
    } 
    
    public void displayVehiclesNeedingMaintenance() {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.isMaintenanceRequired()) {

                vehicle.displayInfo();
            }
        }
    } 
    public void performVehicleMaintenance(String vehicleId) {

        Vehicle vehicle = searchVehicle(vehicleId);

        if (vehicle instanceof Maintainable) {

            Maintainable m = (Maintainable) vehicle;

            m.performMaintenance();
        }
    }
}