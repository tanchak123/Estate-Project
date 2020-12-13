package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends CustomDao<Client, Long>, IteratorCustomDao<Client> {

    Page<Client> findAll(Pageable pageable);
}
