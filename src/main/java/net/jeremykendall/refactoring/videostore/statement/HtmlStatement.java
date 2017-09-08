package net.jeremykendall.refactoring.videostore.statement;

import net.jeremykendall.refactoring.videostore.Customer;
import net.jeremykendall.refactoring.videostore.Rental;

public class HtmlStatement extends Statement {
    HtmlStatement(Customer customer) {
        super(customer);
    }

    @Override
    public String generate() {
        return header() + lineItems() + footer();
    }

    private String header() {
        return "<h1>Rental Record for <em>" + customer.getName() + "</em></h1><p>\n";
    }

    private String lineItems() {
        StringBuilder lineItems = new StringBuilder();

        for (Rental rental: customer.getRentals()) {
            lineItems.append(rental.getMovieTitle())
                    .append(": ")
                    .append(String.valueOf(rental.getCharge()))
                    .append("<br>\n");
        }

        return lineItems.toString();
    }

    private String footer() {
        return totalCharges() + frequentRenterPoints();
    }

    private String totalCharges() {
        return "</p><p>You owe <em>" +
                String.valueOf(getTotalCharge()) +
                "</em></p>\n";
    }

    private String frequentRenterPoints()
    {
        return "<p>On this rental you earned <em>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</em> frequent renter points</p>";
    }
}
