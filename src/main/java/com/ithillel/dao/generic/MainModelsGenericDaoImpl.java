package com.ithillel.dao.generic;

import com.ithillel.model.Region;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class MainModelsGenericDaoImpl<C, L> extends GenericDaoImpl<C, L> {

    public MainModelsGenericDaoImpl(C c) {
        super(c);
    }

    public List<C> getAllSorted(String valueName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<C> criteriaQuery = (CriteriaQuery<C>) criteriaBuilder.createQuery(
                instance.getClass());
        Root<C> root = (Root<C>) criteriaQuery.from(instance.getClass());
        criteriaQuery.select(root);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get(valueName)));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<C> getBetWeen(String valueName, Long from, Long too) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<C> criteriaQuery = (CriteriaQuery<C>) criteriaBuilder.createQuery(
                instance.getClass());
        Root<C> root = (Root<C>) criteriaQuery.from(instance.getClass());
        criteriaQuery
                .select(root)
                .where(criteriaBuilder.between(root.get(valueName), from, too));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<C> getBetWeenTimeStamp(String valueName, Timestamp from, Timestamp too) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<C> criteriaQuery = (CriteriaQuery<C>) criteriaBuilder.createQuery(
                instance.getClass());
        Root<C> root = (Root<C>) criteriaQuery.from(instance.getClass());
        criteriaQuery
                .select(root)
                .where(criteriaBuilder.between(
                        root.get(valueName), from.getTime() ,too.getTime()));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
