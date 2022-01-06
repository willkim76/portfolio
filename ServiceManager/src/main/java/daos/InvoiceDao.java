package daos;

import types.Invoice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the interface between the service layer and the persistent layer
 * for an Invoice type
 */
public class InvoiceDao implements Dao<Invoice> {
    private File invoiceFile;

    public InvoiceDao(File invoiceFile) { this.invoiceFile = invoiceFile; }

    @Override
    public List<Invoice> getAll() {
        List<Invoice> invoices = new ArrayList<>();

        return null;
    }

    @Override
    public Invoice get(String invoiceId) {

        return null;
    }

    @Override
    public void save(Invoice invoice) {

    }

    @Override
    public boolean update(Invoice invoice, String[] params) {
        return false;
    }

    @Override
    public boolean delete(Invoice invoice) {
        return false;
    }
}
