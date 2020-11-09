package com.ithillel.service;

import com.ithillel.dao.interfaces.AreaDao;
import com.ithillel.model.Area;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl extends GenericServiceImpl<Area, Long> implements AreaService {

    private AreaDao areaDao;

    @Autowired
    public AreaServiceImpl(AreaDao areaDao) {
        super(areaDao);
        this.areaDao = areaDao;
    }
}
