package net.jeremykendall.refactoring.videostore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Arthur Dent");
    }

    @Test
    public void statementRentRegularMovieForOneDay() throws Exception {
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, 1));

        String expected = "Rental Record for Arthur Dent\n" +
                "\tKiller Klowns from Outer Space\t2.0\n" +
                "Amount owed is 2.0\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentNewReleaseMovieForOneDay() throws Exception {
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, 1));

        String expected = "Rental Record for Arthur Dent\n" +
                "\tAwesome New Release\t3.0\n" +
                "Amount owed is 3.0\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentChildrensMovieForOneDay() throws Exception {
        customer.addRental(getRental("Cars", Movie.CHILDRENS, 1));

        String expected = "Rental Record for Arthur Dent\n" +
                "\tCars\t1.5\n" +
                "Amount owed is 1.5\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentChildrensMovieForFourDays() throws Exception {
        customer.addRental(getRental("Cars", Movie.CHILDRENS, 4));

        String expected = "Rental Record for Arthur Dent\n" +
                "\tCars\t3.0\n" +
                "Amount owed is 3.0\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentRegularMovieForThreeDays() throws Exception {
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, 3));

        String expected = "Rental Record for Arthur Dent\n" +
                "\tKiller Klowns from Outer Space\t3.5\n" +
                "Amount owed is 3.5\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentNewReleaseMovieForTwoDays() throws Exception {
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, 2));

        String expected = "Rental Record for Arthur Dent\n" +
                "\tAwesome New Release\t6.0\n" +
                "Amount owed is 6.0\n"+
                "You earned 2 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    private Rental getRental(String title, int priceCode, int daysRented) {
        Movie movie = new Movie(title, priceCode);
        return new Rental(movie, daysRented);
    }
}