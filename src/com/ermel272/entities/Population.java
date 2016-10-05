package com.ermel272.entities;

import java.util.ArrayDeque;
import java.util.Queue;

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

    private static Queue<Person> susceptiblePeople;
    private static Queue<Person> infectedPeople;
    private static Queue<Person> recoveredPeople;
    private static Queue<Person> deceasedPeople;

    Population() {
        // Initialize population category lists
        susceptiblePeople = new ArrayDeque<>();
        infectedPeople = new ArrayDeque<>();
        recoveredPeople = new ArrayDeque<>();
        deceasedPeople = new ArrayDeque<>();

        // Initialize the susceptible and infected parts of the population
        initSusceptiblePopulation();
        initInfectedPopulation();
    }

    /**
     * Moves n people from susceptible to infected.
     *
     * @param n
     *          The number of people who are getting sick.
     */
    public void makeSick(final int n) {
        // Move n people from susceptible to infected
        for (int i = 0; i < n; i++) {
            Person person = susceptiblePeople.remove();
            person.setStatus(DiseaseStatus.INFECTED);
            infectedPeople.add(person);
        }
    }

    /**
     * Moves n people from infected to recovered.
     *
     * @param n
     *          The number of people who are recovering.
     */
    public void makeRecover(final int n) {
        // Move n people from infected to recovered
        for (int i = 0; i < n; i++) {
            Person person = infectedPeople.remove();
            person.setStatus(DiseaseStatus.RECOVERED);
            recoveredPeople.add(person);
        }
    }

    /**
     * Moves n people from recovered to susceptible
     *
     * @param n
     *          The number of people who are losing their immunity.
     */
    public void makeUnimmune(final int n) {
        // Move n people from recovered to susceptible
        for (int i = 0; i < n; i++) {
            Person person = recoveredPeople.remove();
            person.setStatus(DiseaseStatus.SUSCEPTIBLE);
            susceptiblePeople.add(person);
        }
    }

    /**
     * Moves n people from infected to deceased.
     *
     * @param n
     *          The number of people who are dieing.
     */
    public void makeDeceased(final int n) {
        // Move n people from infected to deceased
        for (int i = 0; i < n; i++) {
            Person person = infectedPeople.remove();
            person.setStatus(DiseaseStatus.DECEASED);
            deceasedPeople.add(person);
        }
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
            // Create new person who is infected by the disease
            Person newPerson = new Person();
            newPerson.setStatus(DiseaseStatus.INFECTED);

            infectedPeople.add(newPerson);
        }
    }
}
