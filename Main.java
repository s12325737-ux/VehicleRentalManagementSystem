package rentalsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        RentalManagementSystem system =
                new RentalManagementSystem();

        Car car = new Car(
                "C101",
                "Toyota",
                "Camry",
                2023,
                60,
                5,
                "Automatic");

        Motorcycle motorcycle = new Motorcycle(
                "M101",
                "Honda",
                "CBR",
                2022,
                40,
                600,
                true);

        Truck truck = new Truck(
                "T101",
                "Volvo",
                "FH16",
                2024,
                100,
                10);

        system.addVehicle(car);
        system.addVehicle(motorcycle);
        system.addVehicle(truck);

        Customer customer = new Customer(
                "CU101",
                "Ayat",
                "0791234567",
                "ayat@gmail.com",
                "DL1001");

        system.addCustomer(customer);

        Rental rental = new Rental(
                "R101",
                customer,
                car,
                4);

        system.addRental(rental);

        
        String customerId;
        String name;
        String phone;
        String email;
        String license; 
        
        int choice;

        do {

            System.out.println("\n===== Vehicle Rental System =====");

            System.out.println("1. Display Vehicles");
            System.out.println("2. Display Customers");
            System.out.println("3. Display Rentals");
            System.out.println("4. Display Available Vehicles");
            System.out.println("5. Search Vehicle");
            System.out.println("6. Return Vehicle");
            System.out.println("7. Calculate Revenue");
            System.out.println("8. Flag Vehicle For Maintenance");
            System.out.println("9. Display Vehicles Needing Maintenance");
            System.out.println("10. Perform Maintenance");
            System.out.println("11. Register Customer"); 
            System.out.println("12. Add Vehicle"); 
            System.out.println("13. Rent Vehicle");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    system.displayAllVehicles();
                    break;

                case 2:

                    system.displayAllCustomers();
                    break;

                case 3:

                    system.displayAllRentals();
                    break;

                case 4:

                    system.displayAvailableVehicles();
                    break;

                case 5:

                    System.out.print("Enter Vehicle ID: ");
                    String vehicleId = input.next();

                    Vehicle vehicle =
                            system.searchVehicle(vehicleId);

                    if (vehicle != null) {

                        vehicle.displayInfo();
                    } else {

                        System.out.println("Vehicle Not Found");
                    }

                    break;

                case 6:

                    System.out.print("Enter Rental ID: ");
                    String rentalId = input.next();

                    system.returnVehicle(rentalId);

                    break;

                case 7:

                    System.out.println(
                            "Total Revenue = "
                                    + system.calculateRevenue());

                    break;

                case 8:

                    System.out.print("Enter Vehicle ID: ");
                    String id1 = input.next();

                    system.flagVehicleForMaintenance(id1);

                    break;

                case 9:

                    system.displayVehiclesNeedingMaintenance();

                    break;

                case 10:

                    System.out.print("Enter Vehicle ID: ");
                    String id2 = input.next();

                    system.performVehicleMaintenance(id2);

                    break; 
                    
                case 11:

                    System.out.print("Customer ID: ");
                    customerId = input.next();

                    System.out.print("Name: ");
                    name = input.next();

                    System.out.print("Phone: ");
                    phone = input.next();

                    System.out.print("Email: ");
                    email = input.next();

                    System.out.print("License Number: ");
                    license = input.next();

                    Customer c = new Customer(
                            customerId,
                            name,
                            phone,
                            email,
                            license);

                    system.addCustomer(c);

                    System.out.println("Customer Added.");

                    break; 
                    
                case 12:

                    System.out.println("1. Car");
                    System.out.println("2. Motorcycle");
                    System.out.println("3. Truck");

                    int type = input.nextInt();

                    System.out.print("Vehicle ID: ");
                    String id = input.next();

                    System.out.print("Brand: ");
                    String brand = input.next();

                    System.out.print("Model: ");
                    String model = input.next();

                    System.out.print("Year: ");
                    int year = input.nextInt();

                    System.out.print("Price Per Day: ");
                    double price = input.nextDouble();

                    if (type == 1) {

                        Car newCar =
                                new Car(id,
                                        brand,
                                        model,
                                        year,
                                        price,
                                        5,
                                        "Automatic");

                        system.addVehicle(newCar);
                    }

                    else if (type == 2) {

                        Motorcycle newMotorcycle =
                                new Motorcycle(id,
                                        brand,
                                        model,
                                        year,
                                        price,
                                        600,
                                        true);

                        system.addVehicle(newMotorcycle);
                    }

                    else if (type == 3) {

                        Truck newTruck =
                                new Truck(id,
                                        brand,
                                        model,
                                        year,
                                        price,
                                        10);

                        system.addVehicle(newTruck);
                    }

                    break; 
                    
                case 13:

                    System.out.print("Rental ID: ");
                    String newRentalId = input.next();

                    System.out.print("Customer ID: ");
                    String customerID = input.next();

                    Customer customerObj =
                            system.searchCustomer(customerID);

                    System.out.print("Vehicle ID: ");
                    String vehicleID = input.next();

                    Vehicle vehicleObj =
                            system.searchVehicle(vehicleID);

                    System.out.print("Days: ");
                    int days = input.nextInt();

                    if (customerObj != null &&
                        vehicleObj != null &&
                        vehicleObj.isAvailable()) {

                    	Rental newRental =
                    	        new Rental(
                    	                newRentalId,
                    	                customerObj,
                    	                vehicleObj,
                    	                days);

                        system.addRental(newRental);

                        System.out.println(
                                "Vehicle Rented Successfully.");
                    }

                    else {

                        System.out.println(
                                "Invalid Customer or Vehicle.");
                    }

                    break;

                case 0:

                    System.out.println("Program Ended");
                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 0);

        input.close();
    }
}