package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.Region;

import java.sql.Timestamp;
import java.util.List;

public interface RegionDao extends CustomDao<Region, Long> {

    List<Region> getAllSorted(String columnName);

    List<Region> getBetWeen(String columnName, Long from, Long to);

    List<Region> getBetweenTimeStamp(String valueName, Timestamp from, Timestamp too);
}
