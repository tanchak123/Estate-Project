package com.ithillel.dao;

import com.ithillel.dao.generic.GenericDaoImpl;
import com.ithillel.dao.interfaces.CityDao;
import com.ithillel.model.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl extends GenericDaoImpl<City, Long> implements CityDao {

    public CityDaoImpl() {
        super(new City());
    }
}
