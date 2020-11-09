package com.ithillel.dao.generic;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class GenericDaoImpl<C, L> implements CustomDao<C, L> {

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    private C instance;

    public GenericDaoImpl(C c) {
        this.instance = c;
    }

    @Override
    public C create(final C c) {
        entityManager.persist(c);
        return c;
    }

    @Override
    public C get(L id) {
        return (C) entityManager.find(instance.getClass(), id);
    }

    @Override
    public List<C> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<C> criteriaQuery = (CriteriaQuery<C>) criteriaBuilder.createQuery(
                instance.getClass());
        Root<C> root = (Root<C>) criteriaQuery.from(instance.getClass());
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public C update(C instance) {
        entityManager.merge(instance);
        return instance;
    }

    @Override
    public C delete(C instance) {
        entityManager.remove(instance);
        return instance;
    }
}
