package types;

import java.time.ZonedDateTime;

public class Customer {
    private String customerId;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    private InvoiceHistory invoiceHistory;
    private ZonedDateTime joinDate;

    public Customer(String firstName, String lastName, String phoneNumber) {
        this(firstName, lastName, phoneNumber, "");
    }

    public Customer(String firstName, String lastName, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.customerId = firstName.concat(lastName).concat(phoneNumber);

        this.invoiceHistory = new InvoiceHistory(customerId);
        this.joinDate = ZonedDateTime.now();
    }



    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ZonedDateTime getJoinDate() {
        return joinDate;
    }

    public InvoiceHistory getInvoiceHistory() {
        return invoiceHistory;
    }

    // Public methods
    // TODO
    public void addInvoice(Invoice invoice) {

    }

    @Override
    public String toString() {
        return String.format("{%s %s, %s, %s}", firstName, lastName, phoneNumber, address);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer)) return false;
        Customer that = (Customer) o;
        return this.firstName.equals(that.firstName)
                && this.lastName.equals(that.lastName)
                && this.phoneNumber.equals(that.phoneNumber);

    }
}
