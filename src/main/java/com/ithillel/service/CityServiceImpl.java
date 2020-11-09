package com.ithillel.service;

import com.ithillel.dao.interfaces.CityDao;
import com.ithillel.model.City;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends GenericServiceImpl<City, Long> implements CityService {

    @Autowired
    public CityServiceImpl(CityDao cityDao) {
        super(cityDao);
    }
}
