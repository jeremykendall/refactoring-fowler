package net.jeremykendall.refactoring.videostore.statement;

import net.jeremykendall.refactoring.videostore.Customer;
import net.jeremykendall.refactoring.videostore.Rental;

class AsciiStatement extends Statement {
    AsciiStatement(Customer customer) {
        super(customer);
    }

    @Override
    public String generate() {
        return header() + lineItems() + footer();
    }

    private String header() {
        return "Rental Record for " + customer.getName() + "\n";
    }

    private String lineItems() {
        StringBuilder lineItems = new StringBuilder();

        for (Rental rental : customer.getRentals()) {
            lineItems.append("\t")
                    .append(rental.getMovieTitle())
                    .append("\t")
                    .append(String.valueOf(rental.getCharge()))
                    .append("\n");
        }

        return lineItems.toString();
    }

    private String footer() {
        return totalCharges() + frequentRenterPoints();
    }

    private String totalCharges() {
        return "Amount owed is " +
                    String.valueOf(getTotalCharge()) +
                    "\n";
    }

    private String frequentRenterPoints() {
        return "You earned " +
                    String.valueOf(getTotalFrequentRenterPoints()) +
                    " frequent renter points";
    }
}
