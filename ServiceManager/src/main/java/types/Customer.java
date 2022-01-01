package types;

import java.time.ZonedDateTime;

public class Customer {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    private InvoiceHistory invoiceHistory;
    private ZonedDateTime joinDate;

    public Customer(String firstName, String lastName, String phoneNumber) {
        this(
                firstName,
                lastName,
                phoneNumber,
                ""
        );
    }

    // TODO Implement regex to enforce phone number formatting.
    public Customer(String firstName, String lastName, String phoneNumber, String address) {
        this(
                firstName,
                lastName,
                phoneNumber,
                address,
                new InvoiceHistory(firstName.concat(lastName).concat(phoneNumber)),
                ZonedDateTime.now()
        );
    }

    public Customer(String firstName, String lastName, String phoneNumber, String address,
            InvoiceHistory invoiceHistory,
            ZonedDateTime zonedDateTime
    ) {
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.phoneNumber = phoneNumber;
        this.address = address.toUpperCase();
        this.invoiceHistory = invoiceHistory;
        this.joinDate = zonedDateTime;
    }

    // Getters and Setters
    public String getCustomerId() {
        return firstName.concat(lastName).concat(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    // TODO implement persistent local data update
    public void setFirstName(String firstName) {
        // check for customerId conflict
        this.firstName = firstName;
        // update invoicehistoryid
    }

    public String getLastName() {
        return lastName;
    }

    // TODO implement persistent local data update
    public void setLastName(String lastName) {
        // check for conflict
        this.lastName = lastName;
        // update invoicehistoryid
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // TODO implement persistent local data update
    public void setPhoneNumber(String phoneNumber) {
        // check for conflict
        this.phoneNumber = phoneNumber;
        // update invoicehistoryid
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

    @Override
    public String toString() {
        return String.format("{%s %s, %s, %s, %s}", firstName, lastName, phoneNumber, address, joinDate.toString());
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
