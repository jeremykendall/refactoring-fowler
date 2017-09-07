package net.jeremykendall.refactoring.videostore;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test(expected = IllegalArgumentException.class)
    public void setPriceCode() throws Exception {
        new Movie("Star Trek II: The Wrath of Khan", 9999999);
    }
}