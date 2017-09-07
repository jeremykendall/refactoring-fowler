package net.jeremykendall.refactoring.videostore.state;

abstract public class Price {
    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
