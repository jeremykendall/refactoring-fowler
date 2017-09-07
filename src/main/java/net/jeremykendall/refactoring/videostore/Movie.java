package net.jeremykendall.refactoring.videostore;

import net.jeremykendall.refactoring.videostore.state.ChildrensPrice;
import net.jeremykendall.refactoring.videostore.state.NewReleasePrice;
import net.jeremykendall.refactoring.videostore.state.Price;
import net.jeremykendall.refactoring.videostore.state.RegularPrice;

class Movie {
    static final int CHILDRENS = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

    private void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect price code.");
        }
    }
}
