package com.example.BirdSightingSystem.model;

/**
 *   POJO object that contains Bird Sightings information.
 */
public class BirdSighting {
    private int id;
    private String species_name;
    private String description;
    private String image_url;
    private float location_lat ;
    private float location_long ;

    public BirdSighting(int id, String species_name, String description, String image_url, float location_lat, float location_long) {
        this.id = id;
        this.species_name = species_name;
        this.description = description;
        this.image_url = image_url;
        this.location_lat = location_lat;
        this.location_long = location_long;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeciesName() {
        return species_name;
    }

    public void setSpeciesName(String species_name) {
        this.species_name = species_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public float getLocationLat() {
        return location_lat;
    }

    public void setLocationLat(float location_lat) {
        this.location_lat = location_lat;
    }

    public float getLocationLong() {
        return location_long;
    }

    public void setLocationLong(float location_long) {
        this.location_long = location_long;
    }

    @Override
    public String toString() {
        return "BirdSighting{" +
                "id=" + id +
                ", species_name='" + species_name + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                ", location_lat=" + location_lat +
                ", location_long=" + location_long +
                '}';
    }
}
