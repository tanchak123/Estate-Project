package com.ithillel.dao;

import com.ithillel.dao.generic.GenericDaoImpl;
import com.ithillel.dao.interfaces.RegionDao;
import com.ithillel.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegionDaoImpl extends GenericDaoImpl<Region, Long> implements RegionDao {

    @Autowired
    public RegionDaoImpl(Region region) {
        super(region);
    }
}
