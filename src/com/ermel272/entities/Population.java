package com.ermel272.entities;

/**
 * Class:   Population.java
 * Purpose: Models a population of people, dividing
 *          each of them into a category of either susceptible,
 *          infected, recovered, or deceased.
 *
 * Created by chris on 2016-10-04.
 */
public class Population {

    // Set initial population size to fifty million
    private static final int INITIAL_POPULATION_SIZE = 50000000;

    // Set initial number of infected individuals to 2
    private static final int INITIAL_INFECTED_POPULATION = 50;

    private static int susceptiblePeople;
    private static int infectedPeople;
    private static int recoveredPeople;
    private static int deceasedPeople;

    public Population() {
        // Initialize population category lists
        susceptiblePeople = INITIAL_POPULATION_SIZE - INITIAL_INFECTED_POPULATION;
        infectedPeople = INITIAL_INFECTED_POPULATION;
        recoveredPeople = 0;
        deceasedPeople = 0;
    }

    /**
     * Moves n people from susceptible to infected.
     *
     * @param n
     *          The number of people who are getting sick.
     */
    public void makeSick(final int n) {
        // Move n people from susceptible to infected
        susceptiblePeople -= n;
        infectedPeople += n;
    }

    /**
     * Moves n people from infected to recovered.
     *
     * @param n
     *          The number of people who are recovering.
     */
    public void makeRecover(final int n) {
        // Move n people from infected to recovered
        infectedPeople -= n;
        recoveredPeople += n;
    }

    /**
     * Moves n people from recovered to susceptible
     *
     * @param n
     *          The number of people who are losing their immunity.
     */
    public void makeUnimmune(final int n) {
        // Move n people from recovered to susceptible
        recoveredPeople -= n;
        susceptiblePeople += n;
    }

    /**
     * Moves n people from infected to deceased.
     *
     * @param n
     *          The number of people who are dieing.
     */
    public void makeDeceased(final int n) {
        // Move n people from infected to deceased
        infectedPeople -= n;
        deceasedPeople += n;
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
        return susceptiblePeople + infectedPeople + recoveredPeople;
    }

    /**
     * @return The number of people who have died
     */
    public int getDeceasedPopulationSize() { return deceasedPeople; }

    /**
     * @return The number of people who are infected
     */
    public int getInfectedPopulationSize() { return infectedPeople; }

    /**
     * @return The number of people who are susceptible to the disease
     */
    public int getSusceptiblePopulationSize() { return susceptiblePeople; }

    /**
     * @return The number of people who have recovered from the disease
     */
    public int getRecoveredPopulationSize() { return recoveredPeople; }
}
