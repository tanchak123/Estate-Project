package com.ithillel.dao.generic;

import com.ithillel.model.Region;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
        CriteriaQuery<C> criteriaQuery = (CriteriaQuery<C>)
                criteriaBuilder.createQuery(instance.getClass());
        Root<C> root = (Root<C>)criteriaQuery.from(instance.getClass());
        ParameterExpression<Long> pStart = criteriaBuilder.parameter(Long.class);
        ParameterExpression<Long> pEnd = criteriaBuilder.parameter(Long.class);
        criteriaQuery.select(root).where(criteriaBuilder.between(root.get(valueName), pStart, pEnd));
        return entityManager.createQuery(criteriaQuery).
                setParameter(pStart, from).setParameter(pEnd, too).getResultList();
    }

    public List<C> getBetweenTimeStamp(String valueName, Timestamp from, Timestamp too) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<C> criteriaQuery = (CriteriaQuery<C>) criteriaBuilder.createQuery(
                instance.getClass());
        Root<C> root = (Root<C>) criteriaQuery.from(instance.getClass());
        ParameterExpression<Long> pStart = criteriaBuilder.parameter(Long.class);
        ParameterExpression<Long> pEnd = criteriaBuilder.parameter(Long.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.between(root.get(valueName), pStart, pEnd));
        TypedQuery<C> query = entityManager.createQuery(criteriaQuery)
        .setParameter(pStart, from.getTime())
        .setParameter(pEnd, too.getTime());
//        criteriaBuilder.between(root.get(valueName), pStart, pEnd);
        return query.getResultList();
    }
}
