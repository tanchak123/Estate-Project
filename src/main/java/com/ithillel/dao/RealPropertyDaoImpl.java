package com.ithillel.dao;

import com.ithillel.dao.generic.GenericDaoImpl;
import com.ithillel.dao.interfaces.RealPropertyDao;
import com.ithillel.model.RealProperty;
import org.springframework.stereotype.Repository;

@Repository
public class RealPropertyDaoImpl
        extends GenericDaoImpl<RealProperty, Long>
        implements RealPropertyDao {

    public RealPropertyDaoImpl() {
        super(new RealProperty());
    }
}
