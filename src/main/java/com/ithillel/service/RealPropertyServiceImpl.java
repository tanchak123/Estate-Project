package com.ithillel.service;

import com.ithillel.dao.interfaces.RealPropertyDao;
import com.ithillel.model.RealProperty;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.RealPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealPropertyServiceImpl extends GenericServiceImpl<RealProperty, Long>
        implements RealPropertyService {

    @Autowired
    public RealPropertyServiceImpl(RealPropertyDao realPropertyDao) {
        super(realPropertyDao);
    }
}
