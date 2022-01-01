import daos.CustomerDao;
import daos.InvoiceDao;
import daos.InvoiceHistoryDao;

public class ServiceManager {
    CustomerDao customerDao;
    InvoiceDao invoiceDao;
    InvoiceHistoryDao invoiceHistoryDao;

    private ServiceManager(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceHistoryDao invoiceHistoryDao) {
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceHistoryDao = invoiceHistoryDao;
    }

    public static void main(String[] args) {
        // TODO Prompt User to UI
        // TODO Display Options
        // TODO Print Data


    }

    private void introduction() {
        System.out.println("Service Manager Initializing.");

    }
}
