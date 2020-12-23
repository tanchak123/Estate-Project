
package com.ithillel.service;

import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.dao.interfaces.RealPropertyDao;
import com.ithillel.model.RealProperty;
import com.ithillel.service.generic.CustomServiceImpl;
import com.ithillel.service.interfaces.RealPropertyService;
import com.ithillel.utils.interfaces.UtilsInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RealPropertyServiceImpl extends CustomServiceImpl<RealProperty, Long>
        implements RealPropertyService, UtilsInterfaces<RealProperty> {

    RealPropertyDao realPropertyDao;

    @Autowired
    public RealPropertyServiceImpl(RealPropertyDao realPropertyDao
            , IteratorCustomDao<RealProperty> iteratorCustomDao) {
        super(realPropertyDao, new RealProperty(), iteratorCustomDao);
        this.realPropertyDao = realPropertyDao;
    }

    @Override
    public Page<RealProperty> getAllByValueOrderById(String name, String value, Pageable page, Long count) {
        return realPropertyDao.getAllByValueOrderById(new RealProperty(), name, value, page, count);
    }

}

