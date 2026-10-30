package rentalsystem;

public class Customer {

    private String customerId;
    private String fullName;
    private String phone;
    private String email;
    private String licenseNumber;

    public Customer(String customerId,
                    String fullName,
                    String phone,
                    String email,
                    String licenseNumber) {

        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.licenseNumber = licenseNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void displayCustomerInfo() {

        System.out.println("Customer ID: "
                + customerId);

        System.out.println("Name: "
                + fullName);

        System.out.println("Phone: "
                + phone);

        System.out.println("Email: "
                + email);

        System.out.println("License: "
                + licenseNumber);
    }
}