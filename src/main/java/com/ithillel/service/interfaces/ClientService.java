package com.ithillel.service.interfaces;

import com.ithillel.model.Client;
import com.ithillel.service.generic.interfaces.CustomService;
import com.ithillel.service.generic.interfaces.IteratorCustomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService extends CustomService<Client, Long>, IteratorCustomService<Client> {

    Page<Client> findAll(Pageable pageable);



}
