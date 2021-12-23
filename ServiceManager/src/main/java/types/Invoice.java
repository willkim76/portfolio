package types;

import java.time.ZonedDateTime;
import java.util.List;

public class Invoice {
    private static long invoiceId;

    private Customer customer;
    private long rackId;

    private ZonedDateTime dropDateTime;
    private ZonedDateTime pickupDateTime;

    private List<Serviceable> itemsToService;
}
