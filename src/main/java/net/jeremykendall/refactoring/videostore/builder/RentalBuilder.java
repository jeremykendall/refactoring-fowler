package net.jeremykendall.refactoring.videostore.builder;

import net.jeremykendall.refactoring.videostore.Movie;
import net.jeremykendall.refactoring.videostore.Rental;

public class RentalBuilder {
    private Movie movie = MovieBuilder.aMovie().build();
    private int daysRented = 1;

    public static RentalBuilder aRental() {
        return new RentalBuilder();
    }

    public RentalBuilder withMovie(Movie movie) {
        this.movie = movie;

        return this;
    }

    public RentalBuilder withDaysRented(int daysRented) {
        this.daysRented = daysRented;

        return this;
    }

    public Rental build() {
        return new Rental(movie, daysRented);
    }
}
