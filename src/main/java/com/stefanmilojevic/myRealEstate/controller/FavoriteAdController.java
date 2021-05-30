package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.FavoriteAd;
import com.stefanmilojevic.myRealEstate.service.FavoriteAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/favoriteAd")
@RestController
public class FavoriteAdController {

    private FavoriteAdService favoriteAdService;

    @Autowired
    public void setFavoriteAdService(FavoriteAdService favoriteAdService) {
        this.favoriteAdService = favoriteAdService;
    }

    @PostMapping()
    public ResponseEntity<FavoriteAd> save(@RequestBody Advertisement advertisement, HttpServletRequest request) {
        return ResponseEntity.ok(favoriteAdService.save(advertisement, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(favoriteAdService.delete(id));
    }

    @GetMapping("/getAllForLogged")
    public ResponseEntity<List<FavoriteAd>> getAll(HttpServletRequest request) {
        return ResponseEntity.ok(favoriteAdService.getAllForLogged(request));
    }

    @GetMapping("/getByAdvertIdForLogged/{advertId}")
    public ResponseEntity<FavoriteAd> getByAdvertIdForLogged(@PathVariable Long advertId, HttpServletRequest request) {
        return ResponseEntity.ok(favoriteAdService.getByAdvertIdForLogged(advertId,request));
    }
}
