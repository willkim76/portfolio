package daos;

import java.io.File;
import java.util.List;

/**
 * This class is the interface between the service layer and the persistent layer
 * for an InvoiceHistory type
 */
public class InvoiceHistoryDao implements Dao<InvoiceHistoryDao> {
    private File invoiceHistoryFile;

    public InvoiceHistoryDao(File invoiceHistoryFile) {
        this.invoiceHistoryFile = invoiceHistoryFile;
    }

    @Override
    public List<InvoiceHistoryDao> getAll() {
        return null;
    }

    @Override
    public InvoiceHistoryDao get(String id) {
        return null;
    }

    @Override
    public void save(InvoiceHistoryDao invoiceHistoryDao) {

    }

    @Override
    public void update(InvoiceHistoryDao invoiceHistoryDao, String[] params) {

    }

    @Override
    public void delete(InvoiceHistoryDao invoiceHistoryDao) {

    }
}
