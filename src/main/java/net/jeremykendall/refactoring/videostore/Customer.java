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
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    String htmlStatement() {
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1><p>\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            //show figures for this rental
            result += each.getMovie().getTitle() + ": " +
                    String.valueOf(each.getCharge()) + "<br>\n";
        }
        //add footer lines
        result += "</p><p>You owe <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "<p>On this rental you earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) +
                "</em> frequent renter points</p>";
        
        return result;
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
