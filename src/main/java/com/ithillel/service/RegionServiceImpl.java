package com.ithillel.service;

import com.ithillel.dao.interfaces.RegionDao;
import com.ithillel.model.Region;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends GenericServiceImpl<Region, Long> implements RegionService {
    @Autowired
    public RegionServiceImpl(RegionDao regionDao) {
        super(regionDao);
    }

//    @Autowired
//    RegionDao regionDao;
//
//    @Override
//    public Region create(Region region) {
//        return regionDao.create(region);
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
//    public Region delete(Region region) {
//        return regionDao.delete(regionDao.get(region.getId().longValue()));
//    }
//
//    @Override
//    public Region update(Region region) {
//        return regionDao.update(region);
//    }
//
//    @Override
//    public List<Region> getAll() {
//        return regionDao.getAll();
//    }
}
