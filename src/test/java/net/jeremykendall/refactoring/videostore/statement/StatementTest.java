package net.jeremykendall.refactoring.videostore.statement;

import net.jeremykendall.refactoring.videostore.Customer;
import net.jeremykendall.refactoring.videostore.Movie;
import net.jeremykendall.refactoring.videostore.PriceCode;
import net.jeremykendall.refactoring.videostore.Rental;
import net.jeremykendall.refactoring.videostore.builder.MovieBuilder;
import net.jeremykendall.refactoring.videostore.builder.RentalBuilder;
import org.junit.Before;

class StatementTest {
    protected Statement statement;
    Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Arthur Dent");
    }

    Rental getRental(String title, PriceCode priceCode, int daysRented) {
        Movie movie = MovieBuilder.aMovie()
                .withTitle(title)
                .withPriceCode(priceCode)
                .build();

        return RentalBuilder.aRental()
                .withMovie(movie)
                .withDaysRented(daysRented)
                .build();
    }
}
