package com.ithillel.dao;

import com.ithillel.dao.interfaces.AreaDao;
import com.ithillel.model.Area;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
        entityManager.persist(instance);
    }

    @Override
    public Area get(Long id) {
        Area area = entityManager.find(Area.class, Integer.valueOf(String.valueOf(id)));
        area.getDistricts().size();
        return area;

    }

    @Override
    public List<Area> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Area> criteriaQuery = criteriaBuilder.createQuery(Area.class);
        return null;
    }

    @Override
    public Area update(Area instance) {
        return null;
    }

    @Override
    public Area delete(Area instance) {
        return null;
    }

}
