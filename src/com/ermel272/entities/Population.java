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

    // Set initial population size to fifty million
    private static final int INITIAL_POPULATION_SIZE = 50000000;

    // Set initial number of infected individuals to 2
    private static final int INITIAL_INFECTED_POPULATION = 2;

    private static ArrayList<Person> susceptiblePeople;
    private static ArrayList<Person> infectedPeople;
    private static ArrayList<Person> recoveredPeople;
    private static ArrayList<Person> deceasedPeople;

    Population() {
        // Initialize population category lists
        susceptiblePeople = new ArrayList<>();
        infectedPeople = new ArrayList<>();
        recoveredPeople = new ArrayList<>();
        deceasedPeople = new ArrayList<>();

        // Initialize the susceptible and infected parts of the population
        initSusceptiblePopulation();
        initInfectedPopulation();
    }

    /**
     * @return The initial size of the healthy population
     */
    public int getInitialPopulationSize() { return INITIAL_POPULATION_SIZE; }

    /**
     * Returns the number of people in the population who are alive
     *
     * @return The number of people who are alive in the Population
     */
    public int getActivePopulationSize() {
        return susceptiblePeople.size() + infectedPeople.size() + recoveredPeople.size();
    }

    /**
     * Returns the number of people who have died
     *
     * @return The number of people who have died
     */
    public int getDeceasedPopulationSize() { return deceasedPeople.size(); }

    /**
     * Initializes and adds people to the susceptible category of the population
     */
    private void initSusceptiblePopulation() {
        for (int i = 0; i < INITIAL_POPULATION_SIZE - INITIAL_INFECTED_POPULATION; i++) {
            susceptiblePeople.add(new Person());
        }
    }

    /**
     * Initializes and adds people to the infected category of the population
     */
    private void initInfectedPopulation() {
        for (int i = 0; i < INITIAL_INFECTED_POPULATION; i++) {
            infectedPeople.add(new Person());
        }
    }
}
