import daos.CustomerDao;
import daos.InvoiceDao;
import daos.InvoiceHistoryDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

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
        try {
            ServiceManager serviceManager = ServiceManager.initialize();
            serviceManager.promptUser();
        } catch (Exception e) {
            System.err.println("Service Manger Failed to Initialize!");
            e.printStackTrace();
        }
    }

    private static ServiceManager initialize() {
        System.out.println("Service Manager Initializing.");
        return new ServiceManager(
                        App.getCustomerDao(),
                        App.getInvoiceDao(),
                        App.getInvoiceHistoryDao()
        );
    }

    private void promptUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Commands: ");

        String command = "%";
        while (command.toUpperCase().charAt(0) != 'Q') {
            System.out.println("Type command: ");
            command = scanner.nextLine();

        }
    }
}
