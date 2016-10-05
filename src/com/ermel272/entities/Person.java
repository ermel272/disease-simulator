package com.ermel272.entities;

/**
 * Class:   Person.java
 * Purpose: Models a person who can contract a disease and either die or recover
 *
 * Created by Chris on 10/3/2016.
 */
class Person {

    // People start healthy by default
    // Note that this status attribute is actually redundant
    // as people are maintained in a status bucket in the population class
    private DiseaseStatus status = DiseaseStatus.SUSCEPTIBLE;

    public DiseaseStatus getStatus() { return status; }

    void setStatus(final DiseaseStatus status) {
        this.status = status;
    }
}
