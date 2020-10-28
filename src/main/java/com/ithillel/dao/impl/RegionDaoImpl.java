package com.ithillel.dao.impl;

import com.ithillel.dao.CustomDao;
import com.ithillel.dao.interfaces.RegionDao;
import com.ithillel.model.Region;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RegionDaoImpl implements RegionDao {

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    @Transactional
    public void add(final Region region) {
        entityManager.persist(region);
    }

    @Override
    @Transactional
    public Region get(Long id) {
        return entityManager.find(Region.class, Math.toIntExact(id));
    }

    @Override
    public List<Region> getAll() {
        return null;
    }

    @Override
    public Region update(Long id) {
        return null;
    }

    @Override
    public Region delete(Long id) {
        return null;
    }


}
