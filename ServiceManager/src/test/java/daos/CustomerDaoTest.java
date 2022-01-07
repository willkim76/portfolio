package daos;

import java.io.File;
import types.Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerDaoTest {
    private CustomerDao customerDao;
    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() {
        customerDao = new CustomerDao(new File("./src/test/java/data/customertest.csv"));

        String firstName1 = "William";
        String lastName1 = "Kim";
        String phoneNumber1 = "1112223333";
        String address1 = "400 Broad St Seattle WA 98109";
        customer1 = new Customer(firstName1, lastName1, phoneNumber1, address1);

        String firstName2 = "Billy";
        String lastName2 = "Joe";
        String phoneNumber2 = "4445556666";
        String address2 = "400 Broad St Seattle WA 98109";
        customer2 = new Customer(firstName2, lastName2, phoneNumber2, address2);
    }

    @Test
    @Order(1)
    void save_newCustomerWithEmptyFile_savesNewCustomerToPersistentLayer() throws Exception {
        // GIVEN A new Customer
        Customer customer = customer1;

        // WHEN Saving new Customer
        customerDao.save(customer);

        // THEN New Customer exists within the persistent layer
        assertEquals(customer, customerDao.get(customer.getCustomerId()));
    }

    @Test
    @Order(2)
    void save_newCustomerWithNonEmptyFile_savesNewCustomerToPersistentLayer() throws Exception {
        // GIVEN A new Customer
        Customer customer = customer2;

        // WHEN
        customerDao.save(customer);

        // THEN
        assertEquals(customer, customerDao.get(customer.getCustomerId()));
    }

    @Test
    @Order(3)
    void get_withValidCustomerId_returnsCustomer() throws Exception {
        // GIVEN A valid customerId
        String customerId = customer1.getCustomerId();

        // WHEN
        // THEN A customer is returned
        Customer actual = customerDao.get(customerId);
        assertNotNull(actual);
    }

    @Test
    @Order(4)
    void get_withInvalidCustomerId_returnsNull() throws Exception {
        // GIVEN An invalid customerId
        String customerId = "############";

        // WHEN
        // THEN A null is returned
        Customer actual = customerDao.get(customerId);
        assertNull(actual);
    }

    @Test
    @Order(5)
    void delete_withExistingCustomer_removesCustomerFromPersistentLayer() throws Exception {
        // GIVEN An existing Customer
        Customer customer = customerDao.get(customer2.getCustomerId());

        // WHEN Deleting an existing customer
        boolean removed = customerDao.delete(customer);

        // THEN Customer is removed within the persistent layer
        assertTrue(removed, String.format("Expected true but was unexpectedly %s", removed));
        assertNull(customerDao.get(customer.getCustomerId()));
    }

    @Test
    @Order(6)
    void delete_withNonExistingCustomer_persistentLayerUnchanged() throws Exception {
        // GIVEN A Customer not within the persistent layer
        Customer customer = customer2;

        // WHEN Deleting a non-existing customer
        boolean removed = customerDao.delete(customer);

        // THEN Customer is not deleted
        assertFalse(removed, String.format("Expected false but was unexpectedly %s", removed));
    }

    @Test
    @Order(7)
    void update_existingCustomerFirstName_updatesCustomerInPersistentLayer() throws Exception {
        // GIVEN A Customer within the persistent layer
        Customer customer = customer1;
        String expectedFirstName = "CRISTOBAL";
        String expectedLastName = customer1.getLastName();
        String expectedPhoneNumber = customer1.getPhoneNumber();
        String expectedAddress = customer1.getAddress();

        // WHEN Updating a Customers first name
        String[] fields = {expectedFirstName, "", "", ""};
        boolean updated = customerDao.update(customer, fields);

        // THEN Only the Customers first name is updated in the persistent layer
        Customer updatedCustomer = customerDao.getAll().get(0);
        assertTrue(updated, String.format("Expected true but was unexpectedly %s", updated));

        assertEquals(expectedFirstName, updatedCustomer.getFirstName(),
                String.format(
                        "Expected first name %s but was unexpectedly: %s",
                        expectedFirstName,
                        updatedCustomer.getLastName()
                )
        );
        assertEquals(expectedLastName, updatedCustomer.getLastName(),
                String.format(
                        "Expected last name %s but was unexpectedly: %s",
                        expectedLastName,
                        updatedCustomer.getLastName()
                )
        );
        assertEquals(expectedPhoneNumber, updatedCustomer.getPhoneNumber(),
                String.format(
                        "Expected phone number %s but was unexpectedly: %s",
                        expectedPhoneNumber,
                        updatedCustomer.getPhoneNumber()
                )
        );
        assertEquals(expectedAddress, updatedCustomer.getAddress(),
                String.format(
                    "Expected address %s but was unexpectedly: %s",
                    expectedAddress,
                    updatedCustomer.getAddress()
                )
        );
    }

    @Test
    @Order(8)
    void update_nonExistingCustomer_persistentLayerUnchanged() throws Exception {
        // GIVEN A Customer not within the persistent layer
        Customer customer = customer2;

        // WHEN Attempting to update Customer within persistent layer
        String expectedFirstName = "CRISTOBAL";
        String[] fields = {expectedFirstName, "", "", ""};
        boolean updated = customerDao.update(customer, fields);

        // THEN
        assertFalse(updated, String.format("Expected false but was unexpectedly %s", updated));
    }
}
