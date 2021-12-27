package types;

import java.util.ArrayList;
import java.util.List;

public class InvoiceHistory {
    private String invoiceHistoryId;
    private List<String> invoiceHistory;

    public InvoiceHistory(String invoiceHistoryId) {
        this.invoiceHistoryId = invoiceHistoryId;
        this.invoiceHistory = new ArrayList<>();
    }
}
