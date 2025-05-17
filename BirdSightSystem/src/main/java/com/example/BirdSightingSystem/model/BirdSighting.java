package com.example.BirdSightingSystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *   POJO object that contains Bird Sightings information.
 */
public class BirdSighting {
    private int id;
    private String speciesName;

    private String description;

    private String imageUrl;

    private float locationLat;

    private float locationLong;

    public BirdSighting(int id, String species_name, String description, String imageUrl, float locationLat, float locationLong) {
        this.id = id;
        this.speciesName = species_name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.locationLat = locationLat;
        this.locationLong = locationLong;
    }

    public BirdSighting() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String species_name) {
        this.speciesName = species_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image_url) {
        this.imageUrl = image_url;
    }

    public float getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(float location_lat) {
        this.locationLat = location_lat;
    }

    public float getLocationLong() {
        return locationLong;
    }

    public void setLocationLong(float location_long) {
        this.locationLong = location_long;
    }

    @Override
    public String toString() {
        return "BirdSighting{" +
                "id=" + id +
                ", species_name='" + speciesName + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + imageUrl + '\'' +
                ", location_lat=" + locationLat +
                ", location_long=" + locationLong +
                '}';
    }
}
