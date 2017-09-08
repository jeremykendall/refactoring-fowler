package net.jeremykendall.refactoring.videostore;

import lombok.Builder;

@Builder
public class Rental {
    private Movie movie;
    private int daysRented;

    public String getMovieTitle() {
        return movie.getTitle();
    }

    public double getCharge() {
        return movie.getCharge(getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(getDaysRented());
    }

    private int getDaysRented() {
        return daysRented;
    }
}
