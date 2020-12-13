package com.ithillel.service;

import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.dao.interfaces.ClientDao;
import com.ithillel.model.Client;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.generic.interfaces.IteratorCustomService;
import com.ithillel.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements ClientService {

    private final ClientDao clientDao;

    private final Client client;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao, Client client, IteratorCustomDao<Client> iteratorCustomDao) {
        super(clientDao, client, iteratorCustomDao);
        this.clientDao = clientDao;
        this.client = client;
    }

    @Override
    @Transactional
    public Page<Client> findAll(Pageable pageable) {
        return clientDao.findAll(pageable);
    }
}
