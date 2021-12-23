package types;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private static long invoiceId;

    private Customer customer;
    private String rackId;
    private Price price;

    private List<Serviceable> itemsToService;

    private ZonedDateTime dropDateTime;
    private ZonedDateTime pickupDateTime;
    private ZonedDateTime completedDateTime;


    private Invoice() { }

    public static class Builder() {
        private Customer customer;
        private String rackId;
        private Price price;
        private List<Serviceable> itemsToService;

        private ZonedDateTime dropDateTime;
        private ZonedDateTime pickupDateTime;

        public Builder withCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder withRackId(String rackId) {
            this.rackId = rackId;
            return this;
        }

        public Builder withPrice(Price price) {
            this.price = price;
            return this;
        }

        public Builder withItemsToService(List<Serviceable> itemsToService) {
            List<Serviceable> copy = new ArrayList<>();
            for (Serviceable serviceable : itemsToService) {
                copy.add(serviceable);
            }
            itemsToService = copy;
            return this;
        }
    }



}
