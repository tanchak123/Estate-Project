package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.District;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictDao extends CustomDao<District, Long> {
}
