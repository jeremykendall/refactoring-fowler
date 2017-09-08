package net.jeremykendall.refactoring.videostore.statement;

import net.jeremykendall.refactoring.videostore.Customer;
import net.jeremykendall.refactoring.videostore.Movie;
import net.jeremykendall.refactoring.videostore.PriceCode;
import net.jeremykendall.refactoring.videostore.Rental;
import org.junit.Before;

class StatementTest {
    Statement statement;
    Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Arthur Dent");
    }

    Rental getRental(String title, PriceCode priceCode, int daysRented) {
        Movie movie = Movie.builder()
                .title(title)
                .priceCode(priceCode)
                .build();

        return Rental.builder()
                .movie(movie)
                .daysRented(daysRented)
                .build();
    }
}
