package com.ithillel.service.interfaces;

import com.ithillel.model.Client;
import com.ithillel.model.Region;
import com.ithillel.service.generic.interfaces.CustomService;
import com.ithillel.service.generic.interfaces.IteratorCustomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RegionService extends CustomService<Region, Long>, IteratorCustomService<Region> {
//    List<Region> getAllSorted(String columnName);
//
//    List<Region> getBetWeen(String columnName, Long from, Long too);
//
//    List<Region> getBetweenTimeStamp(String valueName, Timestamp from, Timestamp too);

    Page<Region> findAll(Pageable pageable);
}
