package com.ithillel.dao;

import com.ithillel.dao.generic.GenericDaoImpl;
import com.ithillel.dao.interfaces.DistrictDao;
import com.ithillel.model.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DistrictDaoImpl extends GenericDaoImpl<District, Long> implements DistrictDao {

    @Autowired
    public DistrictDaoImpl(District district) {
        super(district);
    }
}
