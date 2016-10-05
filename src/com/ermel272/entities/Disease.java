package com.ermel272.entities;

/**
 * Class:   Disease.java
 * Purpose: Models the disease that is affecting the population.
 *          A disease has an infection, recovery, and mutation rate.
 *          Each rate is a value between 0 and 1.
 *
 * Created by Chris on 10/4/2016.
 */
public class Disease {

    private float mutationRate;
    private float infectionRate;
    private float recoveryRate;

    Disease(final float mutationRate, final float infectionRate, final float recoveryRate) {
        // Ensure all rates given are between 0 and 1
        validateRate(mutationRate);
        validateRate(infectionRate);
        validateRate(recoveryRate);

        this.mutationRate = mutationRate;
        this.recoveryRate = recoveryRate;
        this.infectionRate = infectionRate;
    }

    /**
     * Ensures that the specified rate is between 0 and 1.
     *
     * @param rate
     *      The float value being validated
     */
    private void validateRate(final float rate) {
        // Throws a runtime exception if given rate not between 0 and 1
        if (rate < 0 || rate > 1) {
            throw new RuntimeException("Disease given rate parameter not between 0 and 1.");
        }
    }
}
