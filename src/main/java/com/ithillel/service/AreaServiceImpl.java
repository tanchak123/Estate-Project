package com.ithillel.service;

import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.dao.interfaces.AreaDao;
import com.ithillel.model.Area;
import com.ithillel.model.Client;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl extends GenericServiceImpl<Area, Long> implements AreaService {

    @Autowired
    public AreaServiceImpl(AreaDao areaDao, Area area, IteratorCustomDao<Area> iteratorCustomDao) {
        super(areaDao, area, iteratorCustomDao);
    }
}
