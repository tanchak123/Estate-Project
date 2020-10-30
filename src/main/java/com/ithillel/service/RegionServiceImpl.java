package com.ithillel.service;

import com.ithillel.dao.interfaces.RegionDao;
import com.ithillel.model.Region;
import com.ithillel.service.interfaces.RegionService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegionServiceImpl implements RegionService {

    RegionDao regionDao;

    @Autowired
    public RegionServiceImpl() {
    }

    @Override
    public void create(Region region) {
        regionDao.add(region);
    }

    @Override
    public Region deleteById(Long aLong) {
        return regionDao.delete(getById(aLong));
    }

    @Override
    public Region updateById(Long aLong) {
        return regionDao.update(getById(aLong));
    }

    @Override
    public Region getById(Long aLong) {
        return regionDao.get(aLong);
    }

    @Override
    public Region delete(Region region) {
        return regionDao.delete(region);
    }

    @Override
    public Region update(Region region) {
        return regionDao.update(region);
    }

    @Override
    public List<Region> getAll() {
        return regionDao.getAll();
    }


}
