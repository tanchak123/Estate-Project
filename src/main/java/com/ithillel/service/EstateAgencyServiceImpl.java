package com.ithillel.service;

import com.ithillel.dao.interfaces.EstateAgencyDao;
import com.ithillel.model.EstateAgency;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.EstateAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateAgencyServiceImpl extends GenericServiceImpl<EstateAgency, Long>
        implements EstateAgencyService {

    @Autowired
    public EstateAgencyServiceImpl(EstateAgencyDao estateAgencyDao) {
        super(estateAgencyDao);
    }
}
