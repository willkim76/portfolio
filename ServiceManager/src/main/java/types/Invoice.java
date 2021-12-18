package types;

import java.time.ZonedDateTime;
import java.util.List;

public class Invoice {
    private Customer customer;
    private long invoiceNumber;

    private ZonedDateTime dropDateTime;
    private ZonedDateTime pickupDateTime;

    private List<Serviceable> itemsToService;
}
