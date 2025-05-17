package com.example.BirdSightingSystem.DAO;

import com.example.BirdSightingSystem.model.BirdSighting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Connects to MYSQL Schema mydb and retrieves information related to Users
 */
public class BirdSightingDAO {
    List<BirdSighting> birdSightings = null;
    String selectBirdSightingsSQL = "Select * from mydb.BIRD_SIGHTING;";
    public BirdSightingDAO() {
        //JDBC connection and load driver to MySQL
    }

    public List<BirdSighting> getBirdSightings() {
        List<BirdSighting> birdSightings = new ArrayList<>();
        String selectBirdSightingsSQL = "SELECT * FROM BIRD_SIGHTING";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(selectBirdSightingsSQL);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                BirdSighting sighting = new BirdSighting();
                sighting.setId(resultSet.getInt("id"));
                sighting.setSpeciesName(resultSet.getString("species_name"));
                sighting.setDescription(resultSet.getString("description"));
                sighting.setImageUrl(resultSet.getString("image_url"));
                sighting.setLocationLat(resultSet.getFloat("location_lat"));
                sighting.setLocationLong(resultSet.getFloat("location_long"));

                birdSightings.add(sighting);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database error fetching bird sightings", e);
        }

        return birdSightings;
    }


    public List<BirdSighting> getSearchBirdSightings(String bird_name) {
        //TO DO : Select * from BIRD_SIGHTING table with criteria as birdName.

        return birdSightings;
    }

    public boolean createBirdSighting(BirdSighting sighting) {
        String insertSQL = "INSERT INTO BIRD_SIGHTING (species_name, description, image_url, location_lat, location_long) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            stmt.setString(1, sighting.getSpeciesName());
            stmt.setString(2, sighting.getDescription());
            stmt.setString(3, sighting.getImageUrl());
            stmt.setFloat(4, sighting.getLocationLat());
            stmt.setFloat(5, sighting.getLocationLong());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
