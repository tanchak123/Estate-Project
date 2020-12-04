package com.ithillel.service;

import com.ithillel.dao.interfaces.EstateAgencyDao;
import com.ithillel.model.EstateAgency;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.EstateAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstateAgencyServiceImpl extends GenericServiceImpl<EstateAgency, Long>
        implements EstateAgencyService {

    private final EstateAgencyDao estateAgencyDao;

    private final EstateAgency estateAgency;

    @Autowired
    public EstateAgencyServiceImpl(EstateAgencyDao estateAgencyDao, EstateAgency estateAgency) {
        super(estateAgencyDao);
        this.estateAgencyDao = estateAgencyDao;
        this.estateAgency = estateAgency;
    }

    @Override
    public Page<EstateAgency> getAllByValueOrderById(String name, String value, Pageable page, Long count) {
        return estateAgencyDao.getAllByValueOrderById(estateAgency, name, value, page, count);
    }
}
