package com.example.BirdSightingSystem.service;

import com.example.BirdSightingSystem.DAO.BirdSightingDAO;
import com.example.BirdSightingSystem.model.BirdSighting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BirdSightServiceTest {

    private BirdSightingDAO birdSightingDAOMock;
    private BirdSightService birdSightService;

    @BeforeEach
    public void setup() {
        birdSightingDAOMock = mock(BirdSightingDAO.class);
        birdSightService = new BirdSightService();
        birdSightService.birdSightingDAO = birdSightingDAOMock;
    }

    @Test
    public void testGetAllBirdSightings() {
        List<BirdSighting> result = birdSightService.getAllBirdSightings();

        assertEquals(2, result.size());
    }
    @Test
    public void testCreateBirdSighting_success() {
        BirdSighting sighting = new BirdSighting(1, "Parrot", "Parrot", "www.s3bucket.1", 0.12f,1.2f);
        when(birdSightingDAOMock.createBirdSighting(sighting)).thenReturn(true);

        boolean created = birdSightService.createBirdSighting(sighting);

        assertTrue(created);
    }

    @Test
    public void testCreateBirdSighting_failure() {
        BirdSighting sighting = new BirdSighting(2, "Parrot", "Park", "www.s3bucket.1", 0.12f,1.2f);
        when(birdSightingDAOMock.createBirdSighting(sighting)).thenReturn(false);

        boolean created = birdSightService.createBirdSighting(sighting);

        assertFalse(created);
    }


}
