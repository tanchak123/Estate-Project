package com.ithillel.dao;

import com.ithillel.dao.generic.GenericDaoImpl;
import com.ithillel.dao.interfaces.EstateAgencyDao;
import com.ithillel.model.EstateAgency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EstateAgencyDaoImpl
        extends GenericDaoImpl<EstateAgency, Long>
        implements EstateAgencyDao {

    @Autowired
    public EstateAgencyDaoImpl(EstateAgency estateAgency) {
        super(estateAgency);
    }
}
