package com.ithillel.service;

import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.dao.interfaces.EstateAgencyDao;
import com.ithillel.model.EstateAgency;
import com.ithillel.service.generic.CustomServiceImpl;
import com.ithillel.service.interfaces.EstateAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstateAgencyServiceImpl extends CustomServiceImpl<EstateAgency, Long>
        implements EstateAgencyService {

    private final EstateAgencyDao estateAgencyDao;
    @Autowired
    public EstateAgencyServiceImpl(EstateAgencyDao estateAgencyDao, EstateAgency estateAgency
            , IteratorCustomDao<EstateAgency> iteratorCustomDao) {
        super(estateAgencyDao, estateAgency, iteratorCustomDao);
        this.estateAgencyDao = estateAgencyDao;
    }


//    @Override
//    public Page<EstateAgency> getAllByValueOrderById(String name, String value, Pageable page, Long count) {
//        return estateAgencyDao.getAllByValueOrderById(estateAgency, name, value, page, count);
//    }
}
