package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.City;
import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getById(int id) {
        return cityRepository.findCityById(id);
    }

    @Override
    public City getByUser(User user) {
        return cityRepository.findCityByUsers(user);
    }
}
