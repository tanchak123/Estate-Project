package com.ithillel.service;

import com.ithillel.dao.interfaces.DistrictDao;
import com.ithillel.model.District;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl extends GenericServiceImpl<District, Long> implements DistrictService {

    @Autowired
    public DistrictServiceImpl(DistrictDao districtDao) {
        super(districtDao);
    }
}
