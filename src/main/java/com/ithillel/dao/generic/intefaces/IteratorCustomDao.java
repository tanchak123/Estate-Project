package com.ithillel.dao.generic.intefaces;

import com.ithillel.model.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;


public interface IteratorCustomDao<C> {

    Page<C> getAllByValueOrderById(C c, String name, String value, Pageable page, Long count);
}
