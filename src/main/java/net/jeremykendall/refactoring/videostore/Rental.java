package net.jeremykendall.refactoring.videostore;

class Rental {
    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    double getCharge() {
        return movie.getCharge(getDaysRented());
    }

    int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(getDaysRented());
    }

    private int getDaysRented() {
        return daysRented;
    }
}
