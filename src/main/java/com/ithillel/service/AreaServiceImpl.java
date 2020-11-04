package com.ithillel.service;

import com.ithillel.dao.interfaces.AreaDao;
import com.ithillel.model.Area;
import com.ithillel.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl extends GenericServiceImpl<Area, Long> {

    AreaDao areaDao;

    @Autowired
    public AreaServiceImpl(AreaDao areaDao) {
        super(areaDao);
        this.areaDao = areaDao;
    }
}
