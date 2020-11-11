package com.ithillel.dao;

import com.ithillel.dao.generic.MainModelsGenericDaoImpl;
import com.ithillel.dao.interfaces.RegionDao;
import com.ithillel.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RegionDaoImpl extends MainModelsGenericDaoImpl<Region, Long> implements RegionDao {

    @Autowired
    public RegionDaoImpl(Region region) {
        super(region);
    }

}
