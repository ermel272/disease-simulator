package com.ermel272.entities;

/**
 * Class:   DiseaseStatus.java
 * Purpose: Models the three categories of disease infection as per the SIR three-state model
 *
 * Created by Chris on 10/3/2016.
 */
enum DiseaseStatus {
    SUSCEPTIBLE("susceptible"),
    INFECTED("infected"),
    RECOVERED("recovered"),
    DISEASED("diseased");

    private final String name;

    DiseaseStatus(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
