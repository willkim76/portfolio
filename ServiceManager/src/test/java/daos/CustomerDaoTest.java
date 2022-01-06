package daos;

import java.io.File;
import types.Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDaoTest {
    private CustomerDao customerDao;
    private Customer testCustomer;

    @BeforeEach
    void setUp() throws Exception {
        customerDao = new CustomerDao(new File("./src/test/java/data/customertest.csv"));

        String firstName = "William";
        String lastName = "Kim";
        String phoneNumber = "1112223333";
        String address = "400 Broad St Seattle WA 98109";
        testCustomer = new Customer(firstName, lastName, phoneNumber, address);
    }

    @Test
    void save_newCustomer_savesNewCustomer() {
        // GIVEN A new Customer
        String firstName = "Billy";
        String lastName = "Joe";
        String phoneNumber = "4445556666";
        String address = "400 Broad St Seattle WA 98109";
        Customer customer = new Customer(firstName, lastName, phoneNumber, address);

        // WHEN Saving new Customer
        customerDao.save(customer);

        // THEN New Customer exists within the persistent layer
        assertEquals(customer, customerDao.get(customer.getCustomerId()));
    }

    @Test
    void delete_withExistingCustomer_removesCustomer() {
        // GIVEN An existing Customer
        Customer existing = customerDao.get("BILLYJOE4445556666");

        // WHEN Deleting an existing customer
        boolean removed = customerDao.delete(existing);

        // THEN Customer is removed within the persistent layer
        assertTrue(removed, "Customer does not exist for removal!");
        assertNull(customerDao.get("BILLYJOE4445556666"));
    }

    @Test
    void update_existingCustomer_updateWithNewCustomer() {

    }

    @Test
    void update_nonExistingCustomer_doesNotUpdate() {

    }

    @Test
    void get_withValidCustomerId_returnsCustomer() {
        // GIVEN A valid customerId
        String customerId = testCustomer.getCustomerId();

        // WHEN
        // THEN A customer is returned
        Customer actual = customerDao.get(customerId);
        assertNotNull(actual);
    }

    @Test
    void get_withInvalidCustomerId_returnsNull() {
        // GIVEN An invalid customerId
        String customerId = "############";

        // WHEN
        // THEN A null is returned
        Customer actual = customerDao.get(customerId);
        assertNull(actual);
    }
}
