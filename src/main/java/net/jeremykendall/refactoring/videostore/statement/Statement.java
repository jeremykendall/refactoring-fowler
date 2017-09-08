package net.jeremykendall.refactoring.videostore.statement;

import net.jeremykendall.refactoring.videostore.Customer;
import net.jeremykendall.refactoring.videostore.Rental;

abstract class Statement {

    Customer customer;

    Statement(Customer customer) {
        this.customer = customer;
    }

    abstract String generate();

    double getTotalCharge() {
        return customer.getRentals()
                .stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }

    int getTotalFrequentRenterPoints()
    {
        return customer.getRentals()
                .stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }
}
