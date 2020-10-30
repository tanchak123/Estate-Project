package com.ithillel.dao;

import com.ithillel.dao.interfaces.RegionDao;
import com.ithillel.model.Region;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RegionDaoImpl implements RegionDao {

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void add(final Region region) {
        entityManager.persist(region);
    }

    @Override
    public Region get(Long id) {
        return entityManager.find(Region.class, id.intValue());
    }

    @Override
    public List<Region> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Region> criteriaQuery = criteriaBuilder.createQuery(Region.class);
        Root<Region> root = criteriaQuery.from(Region.class);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    @Override
    public Region update(Region instance) {
        entityManager.merge(instance);
        return instance;
    }

    @Override
    public Region delete(Region instance) {
        entityManager.remove(instance);
        return instance;
    }



}
