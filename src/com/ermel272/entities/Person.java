package com.ermel272.entities;

/**
 * Class:   Person.java
 * Purpose: Models a person who can contract a disease and either die or recover
 *
 * Created by Chris on 10/3/2016.
 */
public class Person {

    // People start healthy by default
    private static DiseaseStatus status = DiseaseStatus.SUSCEPTIBLE;
}
