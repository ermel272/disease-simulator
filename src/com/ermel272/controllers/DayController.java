package com.ermel272.controllers;

import com.ermel272.entities.Disease;
import com.ermel272.entities.Population;
import com.ermel272.views.ConsoleView;

/**
 * Class:   DayController.java
 * Purpose: Controls the flow of time in the simulation.
 *          Days are the base unit of time, and are modelled via a loop iteration.
 *
 * Created by Chris on 10/4/2016.
 */
public class DayController {

    // Modify disease parameters here in order to shape the disease's behaviour
    // Note: Rates must be between 0 and 1, or an error will be thrown
    private static final double INFECTION_RATE = 0.5;
    private static final double RECOVERY_RATE = 0.08;
    private static final double MUTATION_RATE = 0.2;
    private static final double FATALITY_RATE = 0.02;

    // One year is 365 days
    private static final int ONE_YEAR = 365;

    public void beginSimulation() {
        // Initialize the disease and the population
        Population population = new Population();
        Disease disease = new Disease(MUTATION_RATE, INFECTION_RATE, RECOVERY_RATE, FATALITY_RATE);
        ConsoleView view = new ConsoleView();

        // Day 1 marks the beginning of the simulation
        int day = 1;

        // Begin simulation - one iteration represents one day of time
        // Runs the simulation over a period of 'two years'
        while (day < 2 * ONE_YEAR) {

            // Everyday, four things happen
            // 1. People get sick
            population.makeSick(disease.computeNewlySick(population.getInfectedPopulationSize(),
                    population.getSusceptiblePopulationSize(), population.getActivePopulationSize()));

            // 2. People recover
            population.makeRecover(disease.computeNewlyRecovered(population.getInfectedPopulationSize()));

            // 3. The disease mutates
            population.makeUnimmune(disease.computeNewImmunityLoss(population.getRecoveredPopulationSize()));

            // 4. Some sick people (may) die
            population.makeDeceased(disease.computeNewlyDeceased(population.getInfectedPopulationSize()));

            // Output disease status to the console
            view.statusOutput(day, population.getInfectedPopulationSize(), population.getSusceptiblePopulationSize(),
                    population.getRecoveredPopulationSize(), population.getDeceasedPopulationSize());

            // End of the day
            day++;
        }
    }
}
