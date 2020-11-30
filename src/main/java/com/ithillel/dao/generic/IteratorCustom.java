package com.ithillel.dao.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IteratorCustom<C> {

    Page<C> method(String name, String value, Pageable page);
}
