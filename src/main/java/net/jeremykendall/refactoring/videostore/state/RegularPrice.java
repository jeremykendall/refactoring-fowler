package net.jeremykendall.refactoring.videostore.state;

import net.jeremykendall.refactoring.videostore.Movie;

public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
