package com.ermel272;

import com.ermel272.controllers.SimulationController;

/**
 * Class:   Main.java
 * Purpose: Passes execution to the {@link SimulationController}.
 */
public class Main {

    public static void main(String[] args) {
        final SimulationController simulationController = new SimulationController();

        // Run simulation
        simulationController.beginSimulation();
    }
}
