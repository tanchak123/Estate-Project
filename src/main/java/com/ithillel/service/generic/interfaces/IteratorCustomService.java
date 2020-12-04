package com.ithillel.service.generic.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IteratorCustomService<C> {

    Page<C> getAllByValueOrderById(String name, String value, Pageable page, Long count);
}
