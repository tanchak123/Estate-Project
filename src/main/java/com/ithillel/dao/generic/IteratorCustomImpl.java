package com.ithillel.dao.generic;

import com.ithillel.dao.generic.IteratorCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class IteratorCustomImpl<C> implements IteratorCustom<C> {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    C instance;

    public IteratorCustomImpl(C c) {
        this.instance = c;
    }

    @Override
    @Transactional
    public Page<C> method(String name, String value, Pageable page) {
        Page<C> result;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<C> cq = (CriteriaQuery<C>) cb.createQuery(instance.getClass());
        Root<C> root = (Root<C>) cq.from(instance.getClass());
        cq.select(root)
        .where(cb.equal(root.get(name), "value"))
        .orderBy(cb.asc(root.get("id")));
        TypedQuery<C> query = em.createQuery(cq);
        result = new PageImpl<>(query.getResultList(), page, 20);
        return result;
    }
}
