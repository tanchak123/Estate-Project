package com.ithillel.service.generic.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomService<C, L> {

    C create(C c);

    void deleteById(L l);

    C updateById(L l);

    C eagerGetById(L l);

    C getById(final L id);


    void cascadeDelete(final C c);

    void delete(C c);

    C update(C c);

    List<C> getAll();

    Page<C> findAll(Pageable pageable);
}
