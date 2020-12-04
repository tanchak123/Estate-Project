package com.ithillel.dao.generic.intefaces;

import com.ithillel.utils.CustomUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class IteratorCustomDaoImpl<C> implements IteratorCustomDao<C> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<C> getAllByValueOrderById(C c, String name, String value, Pageable page, Long count) {
        Assert.notNull(name, "name is null");
        Assert.notNull(c, "instance is null");
        Assert.notNull(value, "value is null");
        Assert.notNull(page, "page is null");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        String[] mass = name.split("\\.");
        if (!page.hasPrevious()) {
            CriteriaQuery<Long> countQ =  cb.createQuery(Long.class);
            Root<C> countRoot = (Root<C>) countQ.from(c.getClass());
            Predicate expression = CustomUtils.getEqualExpression(cb, countRoot, mass, value);
            countQ.select(cb.count(countRoot)).where(expression);
            TypedQuery<Long> q = em.createQuery(countQ);
            count = q.getSingleResult();
        }
        CriteriaQuery<C> cq = (CriteriaQuery<C>) cb.createQuery(c.getClass());
        Root<C> root = (Root<C>) cq.from(c.getClass());
        cq.select(root);
        Predicate expression = CustomUtils.getEqualExpression(cb, root, mass, value);
        cq.where(expression)
                .orderBy(cb.asc(root.get("id")));
        TypedQuery<C> query = em.createQuery(cq);
        query.setFirstResult(page.getPageSize() * page.getPageNumber());
        query.setMaxResults(page.getPageSize());
        Page<C> result = new PageImpl<>(query.getResultList(), page, count);
        return result;
    }


}
