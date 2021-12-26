import dao.CustomerDao;
import dao.InvoiceDao;
import types.Customer;

import java.util.List;

public class ServiceManager {
    CustomerDao customerDao;
    InvoiceDao invoiceDao;

    private ServiceManager(CustomerDao customerDao, InvoiceDao invoiceDao) {
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
    }

    public static void main(String[] args) {

    }
}
