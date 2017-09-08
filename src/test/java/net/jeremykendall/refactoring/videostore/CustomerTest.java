package net.jeremykendall.refactoring.videostore;

import org.junit.Before;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Arthur Dent");
    }
}