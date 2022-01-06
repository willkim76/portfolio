package types;

import java.time.ZonedDateTime;

public class Customer {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private ZonedDateTime joinDate;

    public Customer(String firstName, String lastName, String phoneNumber) {
        this(firstName, lastName, phoneNumber, "");
    }

    public Customer(String firstName, String lastName, String phoneNumber, String address) {
        this(firstName, lastName, phoneNumber, address, ZonedDateTime.now());
    }

    // TODO Implement regex to enforce phone number formatting.
    public Customer(String firstName, String lastName, String phoneNumber, String address, ZonedDateTime joinDate) {
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.phoneNumber = phoneNumber;
        this.address = address.toUpperCase();
        this.joinDate = joinDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public ZonedDateTime getJoinDate() {
        return joinDate;
    }

    public String getCustomerId() {
        return firstName.concat(lastName).concat(phoneNumber);
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
