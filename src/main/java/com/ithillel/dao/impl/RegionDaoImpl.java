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
    public void get(Long id) {

    }

    @Override
    public void getAll() {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
