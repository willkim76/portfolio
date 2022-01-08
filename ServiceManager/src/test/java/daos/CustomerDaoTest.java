package daos;

import java.io.File;
import java.time.ZonedDateTime;

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

        customer1 = Customer.builder()
                .withFirstName(firstName1)
                .withLastName(lastName1)
                .withPhoneNumber(phoneNumber1)
                .withAddress(address1)
                .build();

        String firstName2 = "Billy";
        String middleName2 = "Bob";
        String lastName2 = "Joe";
        String phoneNumber2 = "4445556666";
        String address2 = "400 Broad St Seattle WA 98109";

        customer2 = Customer.builder()
                .withFirstName(firstName2)
                .withMiddleName(middleName2)
                .withLastName(lastName2)
                .withPhoneNumber(phoneNumber2)
                .withAddress(address2)
                .withJoinDate(ZonedDateTime.now())
                .build();
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
        System.out.println(customer.getCustomerId());
        System.out.println(customer);
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
    void update_existingCustomerFirstName_updatesCustomerInPersistentLayer() throws Exception {
        // GIVEN A Customer within the persistent layer
        Customer customer = customerDao.getAll().get(0);
        String expectedFirstName = "Jack";
        String expectedMiddleName = customer.getMiddleName();
        String expectedLastName = customer.getLastName();
        String expectedPhoneNumber = customer.getPhoneNumber();
        String expectedAddress = customer.getAddress();

        // WHEN Updating a Customers first name
        String[] fields = {expectedFirstName, null, null, null, null};
        boolean updated = customerDao.update(customer, fields);

        // THEN Only the Customers first name is updated in the persistent layer
        Customer updatedCustomer = customerDao.getAll().get(0);
        assertTrue(updated, String.format("Expected true but was unexpectedly %s", updated));

        assertEquals(expectedFirstName, updatedCustomer.getFirstName(),
                String.format(
                        "Expected first name %s but was unexpectedly: %s",
                        expectedFirstName,
                        updatedCustomer.getFirstName()
                )
        );
        assertEquals(expectedMiddleName, updatedCustomer.getMiddleName(),
                String.format(
                        "Expected middle name %s but was unexpectedly: %s",
                        expectedMiddleName,
                        updatedCustomer.getMiddleName()
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
    void update_existingCustomerMiddleName_updatesCustomerInPersistentLayer() throws Exception {
        // GIVEN A Customer within the persistent layer
        Customer customer = customerDao.getAll().get(0);
        String expectedFirstName = customer.getFirstName();
        String expectedMiddleName = "Bob";
        String expectedLastName = customer.getLastName();
        String expectedPhoneNumber = customer.getPhoneNumber();
        String expectedAddress = customer.getAddress();

        // WHEN Updating a Customers middle name
        String[] fields = {null, expectedMiddleName, null, null, null};
        boolean updated = customerDao.update(customer, fields);

        // THEN Only the Customers middle name is updated in the persistent layer
        Customer updatedCustomer = customerDao.getAll().get(0);
        assertTrue(updated, String.format("Expected true but was unexpectedly %s", updated));

        assertEquals(expectedFirstName, updatedCustomer.getFirstName(),
                String.format(
                        "Expected first name %s but was unexpectedly: %s",
                        expectedFirstName,
                        updatedCustomer.getFirstName()
                )
        );
        assertEquals(expectedMiddleName, updatedCustomer.getMiddleName(),
                String.format(
                        "Expected middle name %s but was unexpectedly: %s",
                        expectedMiddleName,
                        updatedCustomer.getMiddleName()
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
    void update_existingCustomerLastName_updatesCustomerInPersistentLayer() throws Exception {
        // GIVEN A Customer within the persistent layer
        Customer customer = customerDao.getAll().get(0);
        String expectedFirstName = customer.getFirstName();
        String expectedMiddleName = customer.getMiddleName();
        String expectedLastName = "Lee";
        String expectedPhoneNumber = customer.getPhoneNumber();
        String expectedAddress = customer.getAddress();

        // WHEN Updating a Customers last name
        String[] fields = {null, null, expectedLastName, null, null};
        boolean updated = customerDao.update(customer, fields);

        // THEN Only the Customers last name is updated in the persistent layer
        Customer updatedCustomer = customerDao.getAll().get(0);
        assertTrue(updated, String.format("Expected true but was unexpectedly %s", updated));

        assertEquals(expectedFirstName, updatedCustomer.getFirstName(),
                String.format(
                        "Expected first name %s but was unexpectedly: %s",
                        expectedFirstName,
                        updatedCustomer.getLastName()
                )
        );
        assertEquals(expectedMiddleName, updatedCustomer.getMiddleName(),
                String.format(
                        "Expected middle name %s but was unexpectedly: %s",
                        expectedMiddleName,
                        updatedCustomer.getMiddleName()
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
    void update_existingCustomerPhoneNumber_updatesCustomerInPersistentLayer() throws Exception {
        // GIVEN A Customer within the persistent layer
        Customer customer = customerDao.getAll().get(0);
        String expectedFirstName = customer.getFirstName();
        String expectedMiddleName = customer.getMiddleName();
        String expectedLastName = customer.getLastName();
        String expectedPhoneNumber = "0001112222";
        String expectedAddress = customer.getAddress();

        // WHEN Updating a Customers phone number
        String[] fields = {null, null, null, expectedPhoneNumber, null};
        boolean updated = customerDao.update(customer, fields);

        // THEN Only the Customers phone number is updated in the persistent layer
        Customer updatedCustomer = customerDao.getAll().get(0);
        assertTrue(updated, String.format("Expected true but was unexpectedly %s", updated));

        assertEquals(expectedFirstName, updatedCustomer.getFirstName(),
                String.format(
                        "Expected first name %s but was unexpectedly: %s",
                        expectedFirstName,
                        updatedCustomer.getLastName()
                )
        );
        assertEquals(expectedMiddleName, updatedCustomer.getMiddleName(),
                String.format(
                        "Expected middle name %s but was unexpectedly: %s",
                        expectedMiddleName,
                        updatedCustomer.getMiddleName()
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
    void update_existingCustomerAddress_updatesCustomerInPersistentLayer() throws Exception {
        // GIVEN A Customer within the persistent layer
        Customer customer = customerDao.getAll().get(0);
        String expectedFirstName = customer.getFirstName();
        String expectedMiddleName = customer.getMiddleName();
        String expectedLastName = customer.getLastName();
        String expectedPhoneNumber = customer.getPhoneNumber();
        String expectedAddress = "675 North Randolph St.";

        // WHEN Updating a Customers address
        String[] fields = {null, null, null, null, expectedAddress};
        boolean updated = customerDao.update(customer, fields);

        // THEN Only the Customers address is updated in the persistent layer
        Customer updatedCustomer = customerDao.getAll().get(0);
        assertTrue(updated, String.format("Expected true but was unexpectedly %s", updated));

        assertEquals(expectedFirstName, updatedCustomer.getFirstName(),
                String.format(
                        "Expected first name %s but was unexpectedly: %s",
                        expectedFirstName,
                        updatedCustomer.getFirstName()
                )
        );
        assertEquals(expectedMiddleName, updatedCustomer.getMiddleName(),
                String.format(
                        "Expected middle name %s but was unexpectedly: %s",
                        expectedMiddleName,
                        updatedCustomer.getMiddleName()
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
    @Order(12)
    void update_nonExistingCustomer_persistentLayerUnchanged() throws Exception {
        // GIVEN A Customer not within the persistent layer
        Customer customer = customer2;

        // WHEN Attempting to update Customer within persistent layer
        String expectedFirstName = "William";
        String[] fields = {expectedFirstName, "", "", "", ""};
        boolean updated = customerDao.update(customer, fields);

        // THEN False is returned
        assertFalse(updated, String.format("Expected false but was unexpectedly %s", updated));
    }
}
