package types;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class InvoiceHistory {
    private String invoiceHistoryId;
    private List<Invoice> invoices;

    public InvoiceHistory(String invoiceHistoryId) {
        this.invoiceHistoryId = invoiceHistoryId;
        this.invoices = new ArrayList<>();
    }

    public String getInvoiceHistoryId() {
        return invoiceHistoryId;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
