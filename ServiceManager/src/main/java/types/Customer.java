package types;

import java.time.ZonedDateTime;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private ZonedDateTime joinDate;

    private List<String> invoiceIds;

}
