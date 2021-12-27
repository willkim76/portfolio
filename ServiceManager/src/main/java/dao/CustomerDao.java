package dao;

import types.Customer;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is the interface between the service layer and the persistent layer.
 */
public class CustomerDao implements Dao<Customer> {
    private File customerFile;

    public CustomerDao(File customerFile) { this.customerFile = customerFile; }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        List<String> customerFile = readInvoiceFiles();
        for (String customerLine : customerFile) {
            String[] customerData = customerLine.split(",");
            String[] fullName = customerData[1].split(" ");
            customers.add(
                    new Customer(
                        fullName[0],
                        fullName[1],
                        customerData[2],
                        customerData[3]
                    )
            );
        }
        return customers;
    }

    @Override
    public Customer get(String id) {
        List<Customer> customers = this.getAll();
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(id)) { return customer; }
        }
        return null;
    }

    // TODO
    @Override
    public void save(Customer customer) {
        try (FileWriter fileWriter = new FileWriter(customerFile, true)) {
            String cString = customer.toString();
            char[] charArray = cString.substring(1, cString.length() - 1).toCharArray();
            for (char c : charArray) { fileWriter.write(c); }
            fileWriter.write('\n');
            fileWriter.close();
        } catch (Exception e) {
            System.err.println("Could not write to file!");
        }
    }

    // TODO
    @Override
    public void update(Customer customer, String[] params) {

    }

    // TODO
    @Override
    public void delete(Customer customer) {

    }

    /**
     * Helper method that reads
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
}
