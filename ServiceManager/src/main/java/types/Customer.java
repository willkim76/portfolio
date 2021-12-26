package types;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    private ZonedDateTime joinDate;

    private List<String> invoiceIds;

    public Customer(String firstName, String lastName, String phoneNumber) {
        this(firstName, lastName, phoneNumber, "");
    }

    public Customer(String firstName, String lastName, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;

        this.customerId = firstName.concat(lastName).concat(phoneNumber);
        this.joinDate = ZonedDateTime.now();
        this.invoiceIds = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
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

    public List<String> getInvoiceIds() {
        return invoiceIds;
    }
}
