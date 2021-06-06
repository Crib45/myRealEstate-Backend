package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.ProfileComments;
import com.stefanmilojevic.myRealEstate.service.ProfileCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/profileComments")
@RestController
public class ProfileCommentsController {

    private final ProfileCommentsService profileCommentsService;

    @Autowired
    public ProfileCommentsController(ProfileCommentsService profileCommentsService) {
        this.profileCommentsService = profileCommentsService;
    }

    @GetMapping("commentedOn/{userId}")
    public ResponseEntity<List<ProfileComments>> getById(@PathVariable Long userId) {
        return ResponseEntity.ok(profileCommentsService.getAllByUserId(userId));
    }

    @PostMapping()
    public ResponseEntity<List<ProfileComments>> save(@RequestBody ProfileComments profileComments, HttpServletRequest request) {
        return ResponseEntity.ok(profileCommentsService.save(profileComments, request));
    }

    @PutMapping("updateSeen")
    public ResponseEntity<String> updateSeen(HttpServletRequest request) {
        return ResponseEntity.ok(profileCommentsService.updateSeen(request));
    }
}
