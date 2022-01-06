package daos;

import types.Customer;

import java.io.File;
import java.io.FileWriter;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is the interface between the service layer and the persistent layer
 * for a Customer type
 */
public class CustomerDao implements Dao<Customer> {
    private File customerFile;

    public CustomerDao(File customerFile) { this.customerFile = customerFile; }

    /**
     * Returns
     * @return
     */
    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        List<String> customerFile = readInvoiceFiles();
        for (String customerLine : customerFile) {
            String[] customerData = customerLine.split(",");
            String[] fullName = customerData[0].split(" ");
            customers.add(
                    new Customer(
                            fullName[0],
                            fullName[1],
                            customerData[1],
                            customerData[2],
                            ZonedDateTime.parse(customerData[3])
                    )
            );
        }
        return customers;
    }

    /**
     * Returns a Customer with a customerId
     * @param id the customerId
     * @return Customer
     */
    @Override
    public Customer get(String id) {
        List<Customer> customers = this.getAll();
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id)) { return customer; }
        }
        return null;
    }

    // TODO
    @Override
    public void save(Customer customer) {
        writeToFile(customer, true);
    }

    // TODO
    @Override
    public boolean update(Customer customer, String[] params) {
        return false;
    }

    // FIXME Does not delete when attempting to remove last customer (EDGE CASE)
    @Override
    public boolean delete(Customer customer) {
        List<Customer> customers = this.getAll();
        if (!customers.remove(customer)) { return false; }
        for (Customer customerRW : customers) {
            writeToFile(customerRW, false);
        }
        return true;
    }

    /**
     * Helper method that reads from File and returns
     * @return
     */
    private List<String> readInvoiceFiles() {
        List<String> fileLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(customerFile)) {
            while (scanner.hasNextLine()) {
                fileLines.add(scanner.nextLine());
            }
            scanner.close();
            return fileLines;
        } catch (Exception e) {
            System.err.println("Cannot not read file at specified location!");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Helper method that writes to File
     * @param customer
     * @param overwrite
     */
    private void writeToFile(Customer customer, boolean overwrite) {
        try (FileWriter fileWriter = new FileWriter(customerFile, overwrite)) {
            String cString = customer.toString().replaceAll(", ", ",");
            char[] charArray = cString.substring(1, cString.length() - 1).toCharArray();
            for (char c : charArray) { fileWriter.write(c); }
            fileWriter.write('\n');
        } catch (Exception e) {
            System.err.println("Could not write to file!");
        }
    }
}
