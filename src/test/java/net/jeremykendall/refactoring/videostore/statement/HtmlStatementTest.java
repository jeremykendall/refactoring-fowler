package net.jeremykendall.refactoring.videostore.statement;

import net.jeremykendall.refactoring.videostore.PriceCode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlStatementTest extends StatementTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        statement = new HtmlStatement(customer);
    }

    @Test
    public void htmlStatementForOneOfEachTypeForFourDays() throws Exception {
        int daysRented = 4;
        customer.addRental(getRental("Killer Klowns from Outer Space", PriceCode.REGULAR, daysRented));
        customer.addRental(getRental("Awesome New Release", PriceCode.NEW_RELEASE, daysRented));
        customer.addRental(getRental("Cars", PriceCode.CHILDRENS, daysRented));

        String expected = "<h1>Rental Record for <em>Arthur Dent</em></h1><p>\n" +
                "Killer Klowns from Outer Space: 5.0<br>\n" +
                "Awesome New Release: 12.0<br>\n" +
                "Cars: 3.0<br>\n" +
                "</p><p>You owe <em>20.0</em></p>\n"+
                "<p>On this rental you earned <em>4</em> frequent renter points</p>";
        assertEquals(expected, statement.generate());
    }
}