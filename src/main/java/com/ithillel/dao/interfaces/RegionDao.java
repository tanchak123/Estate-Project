package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.dao.generic.Iterator;
import com.ithillel.dao.generic.IteratorCustom;
import com.ithillel.model.Region;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionDao extends CustomDao<Region, Long>, IteratorCustom<Region> {


//    List<Region> getAllSorted(String columnName);
//
//    List<Region> getBetWeen(String columnName, Long from, Long to);
//
//    List<Region> getBetweenTimeStamp(String valueName, Timestamp from, Timestamp too);
}
