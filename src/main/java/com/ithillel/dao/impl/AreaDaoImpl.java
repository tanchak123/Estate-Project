package com.ithillel.dao.impl;

import com.ithillel.dao.interfaces.AreaDao;
import com.ithillel.model.Area;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AreaDaoImpl implements AreaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void add(Area instance) {

    }

    @Override
//    @Transactional
    public Area get(Long id) {
        Area area = entityManager.find(Area.class, Integer.valueOf(String.valueOf(id)));
        area.getDistricts().size();
        return area;

    }

    @Override
    public List<Area> getAll() {
        return null;
    }

    @Override
    public Area update(Long id) {
        return null;
    }

    @Override
    public Area delete(Long id) {
        return null;
    }
}
