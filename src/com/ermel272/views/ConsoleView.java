package com.ermel272.views;

/**
 * Class:   ConsoleView.java
 * Purpose: Handles console output formatting for the disease simulator
 *
 * Created by chris on 2016-10-06.
 */
public class ConsoleView {

    /**
     * Outputs the status of the disease's affect on the population via CSV output to the console.
     * Useful for command line output redirect into a textfile for data aggregation.
     *
     * @param day
     *          The time snapshot of the population's status.
     *
     * @param infected
     *          The number of infected people in the population.
     *
     * @param susceptible
     *          The number of susceptible people in the population.
     *
     * @param recovered
     *          The number of recovered people in the population.
     *
     * @param deceased
     *          The number of deceased people in the population.
     */
    public void statusOutput(final int day, final int infected, final int susceptible, final int recovered,
                             final int deceased) {
        // Outputs population status to the console in CSV format for command line redirect into a text file
        System.out.println(day + "," + infected + "," + susceptible + "," + recovered + "," + deceased);
    }
}
