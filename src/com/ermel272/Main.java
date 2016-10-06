package com.ermel272;

import com.ermel272.controllers.DayController;

/**
 * Class:   Main.java
 * Purpose: Passes execution to the {@link com.ermel272.controllers.DayController}.
 */
public class Main {

    public static void main(String[] args) {
        final DayController dayController = new DayController();

        // Run simulation
        dayController.beginSimulation();
    }
}
