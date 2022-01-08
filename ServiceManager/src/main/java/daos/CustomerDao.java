package daos;

import types.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CustomerDao defines the CRUD operations between the service layer and the persistent layer
 * for the Customer type
 */
public class CustomerDao implements Dao<Customer> {
    private File customerFile;

    public CustomerDao(File customerFile) { this.customerFile = customerFile; }

    // FIXME Need to segregate
    /**
     * Returns a list of Customers that exist within the persistent layer
     * @return List of Customers
     * @throws FileNotFoundException
     */
    @Override
    public List<Customer> getAll() throws FileNotFoundException {
        List<Customer> customers = new ArrayList<>();
        List<String> customerFile = readFile();
        for (String customerLine : customerFile) {
            String[] customerData = customerLine.split(",");
            String[] customerName = customerData[0].split(" ");
            String middName = customerName.length == 3 ? customerName[1] : null;
            String lastName = customerName.length == 3 ? customerName[2] : customerName[1];
            customers.add(
                    Customer.builder()
                            .withFirstName(customerName[0])
                            .withMiddleName(middName)
                            .withLastName(lastName)
                            .withPhoneNumber(customerData[1])
                            .withAddress(customerData[2])
                            .withJoinDate(ZonedDateTime.parse(customerData[3]))
                            .build()
            );
        }
        return customers;
    }

    /**
     * Returns a Customer with a customerId if within persistent layer
     * @param id String customerId
     * @return Customer or null for invalid customerId
     * @throws FileNotFoundException
     */
    @Override
    public Customer get(String id) throws FileNotFoundException {
        List<Customer> customers = this.getAll();
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id)) { return customer; }
        }
        return null;
    }

    /**
     * Adds a Customer to the persistent layer
     * @param customer Customer to add to File
     * @throws IOException
     */
    @Override
    public void save(Customer customer) throws IOException {
        this.writeToFile(customer, true);
    }

    /**
     * Removes a Customer from the persistent layer
     * @param customer Customer to move from File
     * @return boolean if the Customer was removed
     * @throws IOException
     */
    @Override
    public boolean delete(Customer customer) throws IOException {
        List<Customer> customers = this.getAll();
        if (!customers.remove(customer)) { return false; }
        if (customers.size() == 0) { customers.add(null); }
        for (Customer customerRW : customers) { this.writeToFile(customerRW, false); }
        return true;
    }

    /**
     * Updates the persistent layer by updating the Customers fields
     * @param customer Customer to update
     * @param params String[] of new Customer parameters
     * @return boolean if the Customer was updated
     * @throws IOException
     */
    @Override
    public boolean update(Customer customer, String[] params) throws IOException {
        List<Customer> customers = this.getAll();
        if (!customers.remove(customer)) { return false; }
        String[] customerFields = this.customerFieldsToUpdate(customer, params);
        customers.add(
                Customer.builder()
                        .withFirstName(customerFields[0])
                        .withMiddleName(customerFields[1])
                        .withLastName(customerFields[2])
                        .withPhoneNumber(customerFields[3])
                        .withAddress(customerFields[4])
                        .withJoinDate(customer.getJoinDate())
                        .build()
        );
        for (Customer customerRW : customers) { this.writeToFile(customerRW, false); }
        return true;
    }

    /**
     * Helper method that performs the reading operation on the customerFile
     * @return List of String
     * @throws FileNotFoundException
     */
    private List<String> readFile() throws FileNotFoundException {
        List<String> fileLines = new ArrayList<>();
        Scanner scanner = new Scanner(customerFile);
        while (scanner.hasNextLine()) { fileLines.add(scanner.nextLine()); }
        scanner.close();
        return fileLines;
    }

    /**
     * Helper method that performs the writing operation on the customerFile
     * @param customer Customer to add to File or null when to clear the File
     * @param append boolean argument to append or overwrite File
     * @throws IOException
     */
    private void writeToFile(Customer customer, boolean append) throws IOException {
        FileWriter fileWriter = new FileWriter(customerFile, append);
        if (customer == null) { fileWriter.write(""); return; }
        String customerStr = customer.toString().replaceAll(", ", ",");
        fileWriter.write(customerStr.substring(1, customerStr.length() - 1));
        fileWriter.write('\n');
        fileWriter.close();
    }

    // FIXME The updateFieldLogic needs to be corrected (Clearing fields and Updating fields)
    /**
     * Helper method that returns a String[] of Customer fields to update.
     * Passing empty Strings return the original Customer fields.
     * @param customer Customer under evaluation
     * @param params String[] fields under evaluation
     * @return String[] of Customer fields
     */
    private String[] customerFieldsToUpdate(Customer customer, String[] params) {
        String cStr = customer.toString().replaceAll(", ", ",");
        String[] cFields = cStr.substring(1, cStr.length() - 1).split(",");
        String[] fullName = cFields[0].split(" ");

        params[0] = params[0] == null ? fullName[0] : params[0];
        if (fullName.length == 3) {
            params[1] = params[1] == null ? fullName[1] : params[1];
            params[2] = params[2] == null ? fullName[2] : params[2];
        } else {
            params[2] = params[2] == null ? fullName[1] : params[2];
        }

        for (int i = 3; i < params.length; i++) {
            params[i] = params[i] == null ? cFields[i - 2] : params[i];
        }
        return params;
    }
}
