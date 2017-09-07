package net.jeremykendall.refactoring.videostore;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

    Customer(String name) {
        this.name = name;
    }

    String statement() {
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            //show figures for this rental
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(String.valueOf(each.getCharge()))
                    .append("\n");
        }
        //add footer lines
        result.append("Amount owed is ")
                .append(String.valueOf(getTotalCharge()))
                .append("\n")
                .append("You earned ")
                .append(String.valueOf(getTotalFrequentRenterPoints()))
                .append(" frequent renter points");

        return result.toString();
    }

    String htmlStatement() {
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("<h1>Rental Record for <em>" + getName() + "</em></h1><p>\n");
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            //show figures for this rental
            result.append(each.getMovie().getTitle())
                    .append(": ")
                    .append(String.valueOf(each.getCharge()))
                    .append("<br>\n");
        }
        //add footer lines
        result.append("</p><p>You owe <em>")
                .append(String.valueOf(getTotalCharge()))
                .append("</em></p>\n")
                .append("<p>On this rental you earned <em>")
                .append(String.valueOf(getTotalFrequentRenterPoints()))
                .append("</em> frequent renter points</p>");
        
        return result.toString();
    }

    void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints()
    {
        int result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }

        return result;
    }

    private String getName() {
        return name;
    }
}
