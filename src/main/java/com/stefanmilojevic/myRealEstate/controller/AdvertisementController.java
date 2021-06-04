package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.dto.AdvertisementDTO;
import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/advertisement")
@RestController
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping()
    public ResponseEntity<Advertisement> save(@RequestBody Advertisement advertisement, HttpServletRequest request) {
        return ResponseEntity.ok(advertisementService.save(advertisement, request));
    }

    @GetMapping("/getAllByLogged")
    public ResponseEntity<List<Advertisement>> getAllByLogged(HttpServletRequest request) {
        return ResponseEntity.ok(advertisementService.getAllByLogged(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(advertisementService.delete(id));
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity<Advertisement> publish(@PathVariable Long id) {
        return ResponseEntity.ok(advertisementService.publish(id));
    }

    @PutMapping("/updateCommentsCheckedAt")
    public ResponseEntity<String> updateCommentsCheckedAt(@RequestBody Advertisement advertisement) {
        return ResponseEntity.ok(advertisementService.updateCommentsCheckedAt(advertisement));
    }

    @GetMapping("/getAllPublishedBySubCategoryId/{subcategoryId}")
    public ResponseEntity<List<AdvertisementDTO>> getAllAdvertDTO(@PathVariable int subcategoryId, HttpServletRequest request) {
        return ResponseEntity.ok(advertisementService.getAllPublishedDTOBySubCategoryId(subcategoryId, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(advertisementService.getById(id));
    }
}
