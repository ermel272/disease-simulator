package com.ermel272.entities;

import java.util.ArrayList;

/**
 * Class:   Population.java
 * Purpose: Models a population of {@link Person}'s, dividing
 *          each of them into a category of either susceptible,
 *          infected, recovered, or deceased.
 *
 * Created by chris on 2016-10-04.
 */
public class Population {

    private static ArrayList<Person> susceptiblePeople;
    private static ArrayList<Person> infectedPeople;
    private static ArrayList<Person> recoveredPeople;
    private static ArrayList<Person> deceasedPeople;

    Population() {
        // TODO: Implement population constructor method
    }

    /**
     *
     * @return
     */
    public int getPopulationSize() {
        return susceptiblePeople.size() + infectedPeople.size() + recoveredPeople.size();
    }
}
