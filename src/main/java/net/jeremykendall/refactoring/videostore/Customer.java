package net.jeremykendall.refactoring.videostore;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    String statement() {
        StringBuilder statement = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental rental: this.rentals) {

            //show figures for this rental
            statement.append("\t")
                    .append(rental.getMovieTitle())
                    .append("\t")
                    .append(String.valueOf(rental.getCharge()))
                    .append("\n");
        }
        //add footer lines
        statement.append("Amount owed is ")
                .append(String.valueOf(getTotalCharge()))
                .append("\n")
                .append("You earned ")
                .append(String.valueOf(getTotalFrequentRenterPoints()))
                .append(" frequent renter points");

        return statement.toString();
    }

    String htmlStatement() {
        StringBuilder statement = new StringBuilder("<h1>Rental Record for <em>" + getName() + "</em></h1><p>\n");
        for (Rental rental: this.rentals) {
            //show figures for this rental
            statement.append(rental.getMovieTitle())
                    .append(": ")
                    .append(String.valueOf(rental.getCharge()))
                    .append("<br>\n");
        }
        //add footer lines
        statement.append("</p><p>You owe <em>")
                .append(String.valueOf(getTotalCharge()))
                .append("</em></p>\n")
                .append("<p>On this rental you earned <em>")
                .append(String.valueOf(getTotalFrequentRenterPoints()))
                .append("</em> frequent renter points</p>");
        
        return statement.toString();
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    private double getTotalCharge() {
        return this.rentals.stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }

    private int getTotalFrequentRenterPoints()
    {
        return this.rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }

    private String getName() {
        return name;
    }
}
