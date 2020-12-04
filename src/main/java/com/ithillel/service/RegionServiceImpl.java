package com.ithillel.service;

import com.ithillel.dao.interfaces.RegionDao;
import com.ithillel.model.Region;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class RegionServiceImpl extends GenericServiceImpl<Region, Long>
        implements RegionService {

    private final RegionDao regionDao;

    @Autowired
    public RegionServiceImpl(RegionDao regionDao) {
        super(regionDao);
        this.regionDao = regionDao;
    }


//    @Transactional(readOnly = true)
//    public List<Region> getAllSorted(String columnName) {
//        return regionDao.getAllSorted(columnName);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<Region> getBetWeen(String columnName, Long from, Long too) {
//        return regionDao.getBetWeen(columnName, from, too);
//    }
//
//    @Transactional(readOnly = true)
//    public List<Region> getBetweenTimeStamp(String valueName, Timestamp from, Timestamp too) {
//        return regionDao.getBetweenTimeStamp(valueName, from, too);
//    }
}
