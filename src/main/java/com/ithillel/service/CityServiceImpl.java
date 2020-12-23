package com.ithillel.service;

import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.dao.interfaces.CityDao;
import com.ithillel.model.City;
import com.ithillel.service.generic.CustomServiceImpl;
import com.ithillel.service.interfaces.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends CustomServiceImpl<City, Long> implements CityService {

    @Autowired
    public CityServiceImpl(CityDao cityDao, IteratorCustomDao<City> iteratorCustomDao) {
        super(cityDao, new City(), iteratorCustomDao);
    }

}
