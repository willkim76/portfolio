import daos.CustomerDao;
import daos.InvoiceDao;
import daos.InvoiceHistoryDao;

import java.io.File;

public class App {

    private App() {}

    public static CustomerDao getCustomerDao() {
        return new CustomerDao(
                new File("./src/main/java/data/customer.csv")
        );
    }

    public static InvoiceDao getInvoiceDao() {
        return new InvoiceDao(
                new File("./src/main/java/data/invoice.csv")
        );
    }

    public static InvoiceHistoryDao getInvoiceHistoryDao() {
        return new InvoiceHistoryDao(
                new File("./src/main/java/data/invoicehistory.csv")
        );
    }

}
