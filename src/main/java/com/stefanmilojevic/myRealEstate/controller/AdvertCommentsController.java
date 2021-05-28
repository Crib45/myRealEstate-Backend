package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.AdvertComments;
import com.stefanmilojevic.myRealEstate.service.AdvertCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/advertComments")
@RestController
public class AdvertCommentsController {

    private final AdvertCommentsService advertCommentsService;

    @Autowired
    public AdvertCommentsController(AdvertCommentsService advertCommentsService) {
        this.advertCommentsService = advertCommentsService;
    }

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody AdvertComments advertComments) {
        return ResponseEntity.ok(advertCommentsService.save(advertComments));
    }

    @GetMapping("/getAllByAdvertId/{advertId}")
    public ResponseEntity<List<AdvertComments>> getAllByAdvertId(@PathVariable Long advertId){
        return ResponseEntity.ok(advertCommentsService.getAllByAdvertId(advertId));
    }
}
