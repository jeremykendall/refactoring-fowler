package net.jeremykendall.refactoring.videostore;

import lombok.Builder;
import net.jeremykendall.refactoring.videostore.state.ChildrensPrice;
import net.jeremykendall.refactoring.videostore.state.NewReleasePrice;
import net.jeremykendall.refactoring.videostore.state.Price;
import net.jeremykendall.refactoring.videostore.state.RegularPrice;

public class Movie {
    private String title;
    private Price price;

    @Builder
    public Movie(String title, PriceCode priceCode) {
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

    private void setPriceCode(PriceCode priceCode) {
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
        }
    }
}
