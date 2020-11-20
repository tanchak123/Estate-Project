package com.ithillel.dao;

import com.ithillel.dao.generic.GenericDaoImpl;
import com.ithillel.dao.generic.MainModelsGenericDaoImpl;
import com.ithillel.dao.interfaces.RealtorDao;
import com.ithillel.model.Realtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RealtorDaoImpl extends MainModelsGenericDaoImpl<Realtor, Long> implements RealtorDao {

    @Autowired
    public RealtorDaoImpl(Realtor realtor) {
        super(realtor);
    }
}
