package com.example.BirdSightingSystem.service;

import com.example.BirdSightingSystem.DAO.BirdSightingDAO;
import com.example.BirdSightingSystem.model.BirdSighting;
import com.example.BirdSightingSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BirdSightService {
    private List<BirdSighting> birdSightings;
    public BirdSightingDAO birdSightingDAO;

    public BirdSightService() {
        birdSightingDAO = new BirdSightingDAO();
    }

    /**
     * returns all Bird sightings available.
     * @return
     */

    public List<BirdSighting> getAllBirdSightings() {
        //Get from DAO and Database.
        return birdSightingDAO.getBirdSightings();
    }


    /**
     * returns one Bird sighting given an ID.
     * @return
     */
    public BirdSighting getBirdSighting(Integer id) {
        List<BirdSighting> list = birdSightingDAO.getBirdSightings();
        for(BirdSighting birdSighting:  list){
            if(birdSighting.getId() == id){
                return birdSighting;
            }
        }
        return null;
    }

    /**
     * Creates a bird sighting
     * @param birdSighting
     * @return
     */
    public boolean createBirdSighting(BirdSighting birdSighting) {
        return birdSightingDAO.createBirdSighting(birdSighting);
    }


}
