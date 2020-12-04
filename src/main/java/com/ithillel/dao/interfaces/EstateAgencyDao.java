package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.model.EstateAgency;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateAgencyDao extends CustomDao<EstateAgency, Long>, IteratorCustomDao<EstateAgency> {

}
