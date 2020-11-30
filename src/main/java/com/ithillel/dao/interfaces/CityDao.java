package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends CustomDao<City, Long> {

}
