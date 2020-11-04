package com.ithillel.service;

import com.ithillel.dao.interfaces.CityDao;
import com.ithillel.model.City;
import com.ithillel.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends GenericServiceImpl<City, Long> {

    @Autowired
    public CityServiceImpl(CityDao cityDao) {
        super(cityDao);
    }
}
