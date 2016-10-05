package com.ermel272.entities;

import static java.lang.Math.round;

/**
 * Class:   Disease.java
 * Purpose: Models the disease that is affecting the population.
 *          A disease has an infection, recovery, fatality, and mutation rate.
 *          Each rate is a value between 0 and 1.
 *
 * Created by Chris on 10/4/2016.
 */
public class Disease {

    private double mutationRate;
    private double infectionRate;
    private double recoveryRate;
    private double fatalityRate;

    Disease(final double mutationRate, final double infectionRate, final double recoveryRate, final double fatalityRate) {
        // Ensure all rates given are between 0 and 1
        validateRates(mutationRate, infectionRate, recoveryRate, fatalityRate);

        this.mutationRate = mutationRate;
        this.recoveryRate = recoveryRate;
        this.infectionRate = infectionRate;
        this.fatalityRate = fatalityRate;
    }

    /**
     * Computes the number of people who become newly sick because of the disease.
     *
     * @param infected
     *          The number of infected people thus far.
     *
     * @param susceptible
     *          The number of remaining people who are susceptible to the disease.
     *
     * @param population
     *          The total number of infected, susceptible, and recovered people.
     *
     * @return  The number of people who will get sick.
     */
    public long computeNewlySick(final int infected, final int susceptible, final int population) {
        return round(infectionRate * infected * (susceptible / population));
    }

    /**
     * Computes the number of people who recover from the disease.
     *
     * @param infected
     *          The number of infected people thus far.
     *
     * @return  The number of people who will recover from the disease.
     */
    public long computeNewlyRecovered(final int infected) {
        return round(recoveryRate * infected);
    }

    /**
     * Computes the number of people who die from the disease.
     *
     * @param infected
     *          The number of infected people thus far.
     *
     * @return  The number of people who will die from the disease.
     */
    public long computeNewlyDeceased(final int infected) {
        return round(fatalityRate * infected);
    }

    /**
     * Computes the number of people who lose their immunity to the disease.
     * People who have recovered from this disease are considered to be immune.
     *
     * @param recovered
     *          The number of people who have recovered from the disease thus far.
     *
     * @return  The number of people who will become susceptible to the disease again.
     */
    public long computeNewImmunityLoss(final int recovered) {
        return round(mutationRate * recovered);
    }

    /**
     * Validates each of the disease rate parameters, ensuring they
     * are between 0 and 1.
     *
     * @param mutationRate
     *          The rate at which the disease mutates.
     *
     * @param infectionRate
     *          The rate at which people get infected by the disease.
     *
     * @param recoveryRate
     *          The rate at which people recover from the disease.
     *
     * @param fatalityRate
     *          The rate at which people die once infected by the disease.
     */
    private void validateRates(double mutationRate, double infectionRate, double recoveryRate, double fatalityRate) {
        validateRate(mutationRate);
        validateRate(infectionRate);
        validateRate(recoveryRate);
        validateRate(fatalityRate);
    }

    /**
     * Ensures that the specified rate is between 0 and 1.
     *
     * @param rate
     *      The double value being validated
     */
    private void validateRate(final double rate) {
        // Throws a runtime exception if given rate not between 0 and 1
        if (rate < 0 || rate > 1) {
            throw new RuntimeException("Disease given rate parameter not between 0 and 1.");
        }
    }
}
