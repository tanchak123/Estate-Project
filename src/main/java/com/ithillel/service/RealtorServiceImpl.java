package com.ithillel.service;

import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.dao.interfaces.RealtorDao;
import com.ithillel.model.Realtor;
import com.ithillel.service.generic.CustomServiceImpl;
import com.ithillel.service.interfaces.RealtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RealtorServiceImpl extends CustomServiceImpl<Realtor, Long> implements RealtorService {

    RealtorDao realtorDao;

    @Autowired
    public RealtorServiceImpl(RealtorDao realtorDao, IteratorCustomDao<Realtor> iteratorCustomDao) {
        super(realtorDao, new Realtor(), iteratorCustomDao);
        this.realtorDao = realtorDao;
    }

    @Override
    public Page<Realtor> getAllByValueOrderById(String name, String value, Pageable page, Long count) {
        return realtorDao.getAllByValueOrderById(new Realtor(), name, value, page, count);
    }


}
