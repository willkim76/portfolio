package daos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import types.Customer;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceHistoryDaoTest {
    private InvoiceHistoryDao invoiceHistoryDao;

    @BeforeEach
    void setUp() {
        invoiceHistoryDao =
                new InvoiceHistoryDao((new File("./src/test/java/data/invoicehistorytest.csv")));

    }

    @Test
    @Order(1)
    void save_newCustomerWithEmptyFile_savesNewCustomerToPersistentLayer() throws Exception {
        // GIVEN A new Customer

        // WHEN Saving new Customer

        // THEN New Customer exists within the persistent layer

    }

}
