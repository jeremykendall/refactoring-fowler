package net.jeremykendall.refactoring.videostore.state;

import net.jeremykendall.refactoring.videostore.Movie;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
