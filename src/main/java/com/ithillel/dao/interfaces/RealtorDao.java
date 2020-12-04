package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.model.Realtor;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtorDao extends CustomDao<Realtor, Long>, IteratorCustomDao<Realtor> {
}
