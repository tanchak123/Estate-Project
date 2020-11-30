package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.Area;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaDao extends CustomDao<Area, Long> {

}
