package com.ithillel.service;

import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.dao.interfaces.DistrictDao;
import com.ithillel.model.District;
import com.ithillel.service.generic.CustomServiceImpl;
import com.ithillel.service.interfaces.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl extends CustomServiceImpl<District, Long> implements DistrictService {

    @Autowired
    public DistrictServiceImpl(DistrictDao districtDao, IteratorCustomDao<District> iteratorCustomDao) {
        super(districtDao, new District(), iteratorCustomDao);
    }
}
