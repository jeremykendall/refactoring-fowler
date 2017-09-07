package net.jeremykendall.refactoring.videostore.state;

import net.jeremykendall.refactoring.videostore.Movie;

public class ChildrensPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
