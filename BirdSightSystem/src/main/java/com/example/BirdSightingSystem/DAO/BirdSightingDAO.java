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
        birdSightings = new ArrayList<>();
        birdSightings.add(new BirdSighting(1,"Blue Jay", "beautifulbird","www.s3.url",37.7348257f,-121.948575f ));
        birdSightings.add(new BirdSighting(2,"Quail", "cute bird","www.s3.url",37.7348257f,-121.948575f ));

    }

    public List<BirdSighting> getBirdSightings() {
        //TODO : Implement retrieving birdSightings from DB table BIRD_SIGHTING
        //select * from BIRD_SIGHTING
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(selectBirdSightingsSQL);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("species_name");
                String desc = resultSet.getString("description");

                System.out.printf("ID: %d, Name: %s, Email: %s%n", id, name, desc);
            }

            // Close resources
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            throw new RuntimeException(e);
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
