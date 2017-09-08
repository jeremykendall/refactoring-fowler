package net.jeremykendall.refactoring.videostore.builder;

import net.jeremykendall.refactoring.videostore.Movie;
import net.jeremykendall.refactoring.videostore.PriceCode;

public class MovieBuilder {
    private String title = "Summer Blockbuster";
    private PriceCode priceCode = PriceCode.REGULAR;

    public static MovieBuilder aMovie() {
        return new MovieBuilder();
    }

    public MovieBuilder withTitle(String title) {
        this.title = title;

        return this;
    }

    public MovieBuilder withPriceCode(PriceCode priceCode) {
        this.priceCode = priceCode;

        return this;
    }

    public Movie build() {
        return new Movie(title, priceCode);
    }
}
