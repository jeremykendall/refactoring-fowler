package net.jeremykendall.refactoring.videostore;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

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
