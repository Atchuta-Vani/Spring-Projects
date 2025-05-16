package com.example.BirdSightingSystem.validator;

import com.example.BirdSightingSystem.model.BirdSighting;

/**
 * Validator that checks if create bird sightings have valid input data
 */
public class BirdSightingValidator {
    public boolean validate(BirdSighting birdSighting) {
        if(birdSighting.getSpeciesName().startsWith("!")){
            return false;
        }
        return true;
    }
}
