package com.ithillel.service;

import com.ithillel.dao.interfaces.RealtorDao;
import com.ithillel.model.Realtor;
import com.ithillel.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealtorServiceImpl extends GenericServiceImpl<Realtor, Long> {

    @Autowired
    public RealtorServiceImpl(RealtorDao realtorDao) {
        super(realtorDao);
    }

}
