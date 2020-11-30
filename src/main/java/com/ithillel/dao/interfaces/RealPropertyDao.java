package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.RealProperty;
import org.springframework.stereotype.Repository;

@Repository
public interface RealPropertyDao extends CustomDao<RealProperty, Long> {

}
