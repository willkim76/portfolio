package dao;

import types.Customer;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public Customer get(String customerId) {
        List<String> customerFile = readInvoiceFiles();
        for (String customerLine : customerFile) {
            String[] customerData = customerLine.split(",");
            if (customerData[0].equals(customerId)) {
                String[] fullName = customerData[1].split(" ");
                return new Customer(
                        fullName[0],
                        fullName[1],
                        customerData[2],
                        customerData[3]
                );
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void update(Customer customer, String[] params) {

    }

    @Override
    public void delete(Customer customer) {

    }

    public List<String> readInvoiceFiles() {
        List<String> fileLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(customerFile)) {
            while (scanner.hasNextLine()) {
                fileLines.add(scanner.nextLine());
            }
            return fileLines;
        } catch (Exception e) {
            System.err.println("Cannot not read file at specified location!");
            e.printStackTrace();
        }
        return null;
    }
}
