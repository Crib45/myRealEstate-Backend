package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.City;

import java.util.ArrayList;
import java.util.List;

public interface CityService {
    List<City> getAll();
    City getById(int id);
}
