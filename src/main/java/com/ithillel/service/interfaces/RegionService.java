package com.ithillel.service.interfaces;

import com.ithillel.model.Region;
import com.ithillel.service.generic.CustomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;

public interface RegionService extends CustomService<Region, Long> {
//    List<Region> getAllSorted(String columnName);
//
//    List<Region> getBetWeen(String columnName, Long from, Long too);
//
//    List<Region> getBetweenTimeStamp(String valueName, Timestamp from, Timestamp too);

    Page<Region> getAllByValueOrderById(String name, String value, Pageable page);
}
