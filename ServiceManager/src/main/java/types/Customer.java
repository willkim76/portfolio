package types;

import java.time.ZonedDateTime;

public class Customer {
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private ZonedDateTime joinDate;

    private Customer(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.joinDate = builder.joinDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public ZonedDateTime getJoinDate() {
        return this.joinDate;
    }

    public String getCustomerId() {

        return this.firstName.concat(this.middleName).concat(this.lastName).concat(this.phoneNumber);
    }

    @Override
    public String toString() {
        return String.format(
                "{%s %s%s, %s, %s, %s}",
                this.firstName,
                this.middleName.equals("") ? this.middleName : this.middleName.concat(" "),
                this.lastName,
                this.phoneNumber,
                this.address,
                this.joinDate.toString()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer)) return false;
        Customer that = (Customer) o;
        return this.firstName.equals(that.firstName)
                && this.middleName.equals(that.middleName)
                && this.lastName.equals(that.lastName)
                && this.phoneNumber.equals(that.phoneNumber);
    }

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private String phoneNumber;
        private String address;
        private ZonedDateTime joinDate;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withJoinDate(ZonedDateTime joinDate) {
            this.joinDate = joinDate;
            return this;
        }

        public Customer build() {
            if (this.middleName == null) { this.middleName = ""; }
            if (this.joinDate == null) { this.joinDate = ZonedDateTime.now(); }
            return new Customer(this);
        }
    }
}
