package com.ithillel.service;

import com.ithillel.dao.interfaces.RegionDao;
import com.ithillel.model.Region;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RegionServiceImpl extends GenericServiceImpl<Region, Long> implements RegionService {

    RegionDao regionDao;

    @Autowired
    public RegionServiceImpl(RegionDao regionDao) {
        super(regionDao);
        this.regionDao = regionDao;
    }

    public List<Region> getAllSorted(String columnName) {
        return regionDao.getAllSorted(columnName);
    }

    @Override
    public List<Region> getBetWeen(String columnName, Long from, Long too) {
        return regionDao.getBetWeen(columnName, from, too);
    }

    public List<Region> getBetWeenTimeStamp(String valueName, Timestamp from, Timestamp too) {
        return regionDao.getBetWeenTimeStamp(valueName, from, too);
    }

//    @Autowired
//    RegionDao regionDao;
//
//    @Override
//    public Region create(Region service.region) {
//        return regionDao.create(service.region);
//    }
//
//    @Override
//    public Region deleteById(Long aLong) {
//        return regionDao.delete(getById(aLong));
//    }
//
//    @Override
//    public Region updateById(Long aLong) {
//        return regionDao.update(getById(aLong));
//    }
//
//    @Override
//    public Region getById(Long aLong) {
//        return regionDao.get(aLong);
//    }
//
//    @Override
//    public Region delete(Region service.region) {
//        return regionDao.delete(regionDao.get(service.region.getId().longValue()));
//    }
//
//    @Override
//    public Region update(Region service.region) {
//        return regionDao.update(service.region);
//    }
//
//    @Override
//    public List<Region> getAll() {
//        return regionDao.getAll();
//    }
}
