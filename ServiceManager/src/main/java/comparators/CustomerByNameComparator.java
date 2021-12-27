package comparators;

import types.Customer;

import java.util.Comparator;

/**
 * Defines a lexicographical hierarchy for Customers by last name, first name, then phone number.
 */
public class CustomerByNameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
       if (o1.getLastName().equals(o2.getLastName())) {
           if (o1.getFirstName().equals(o2.getFirstName())) {
               return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
           }
           return o1.getFirstName().compareTo(o2.getFirstName());
       }
       return o1.getLastName().compareTo(o2.getLastName());
    }
}
