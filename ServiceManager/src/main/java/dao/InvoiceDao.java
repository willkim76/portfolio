package dao;

import types.Invoice;

import java.io.File;
import java.util.List;

public class InvoiceDao implements Dao<Invoice> {
    private File invoiceFile;

    public InvoiceDao(File invoiceFile) { this.invoiceFile = invoiceFile; }

    @Override
    public List<Invoice> getAll() {
        return null;
    }

    @Override
    public Invoice get(String id) {
        return null;
    }

    @Override
    public void save(Invoice invoice) {

    }

    @Override
    public void update(Invoice invoice, String[] params) {

    }

    @Override
    public void delete(Invoice invoice) {

    }
}
