package com.example.BirdSightingSystem.api.controller;

import com.example.BirdSightingSystem.model.BirdSighting;
import com.example.BirdSightingSystem.service.BirdSightService;
import com.example.BirdSightingSystem.validator.BirdSightingValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/birdsightings")
public class BirdSightController {
    BirdSightService birdSightService;
    BirdSightingValidator birdSightingValidator;

    public BirdSightController() {
        this.birdSightService = new BirdSightService();
        this.birdSightingValidator = new BirdSightingValidator();

    }

    public BirdSightService getBirdSightService() {
        return birdSightService;
    }

    @GetMapping("/{id}")
    public BirdSighting getBirdSighting(@PathVariable Integer id){
        BirdSighting birdSightings = (BirdSighting) this.birdSightService.getBirdSighting(id);
        return birdSightings;
    }

    @GetMapping("/")
    public List<BirdSighting> getBirdSightings(){
        List<BirdSighting> birdSightings = this.birdSightService.getAllBirdSightings();
        return birdSightings;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createBirdSighting(@RequestBody BirdSighting birdSighting) {
        System.out.println("Adding BirdSighting: " + birdSighting);
        boolean isValid = birdSightingValidator.validate(birdSighting);
        if(isValid){
            this.birdSightService.createBirdSighting(birdSighting);
            return (ResponseEntity) ResponseEntity.ok();
        }
        else
            return (ResponseEntity) ResponseEntity.badRequest();
    }

}
