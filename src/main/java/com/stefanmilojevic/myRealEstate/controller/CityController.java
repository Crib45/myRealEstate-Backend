package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.City;
import com.stefanmilojevic.myRealEstate.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cities")
@RestController
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * Returns list of all available cities
     * @return List of <code>City</code>
     */
    @GetMapping()
    public ResponseEntity<List<City>> getAll() {
        return ResponseEntity.ok(cityService.getAll());
    }

    /**
     * Return <code>City</code> by id
     * @param id id of <code>City</code>
     * @return <code>City</code> object
     */
    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable int id) {
        return ResponseEntity.ok(cityService.getById(id));
    }
}
