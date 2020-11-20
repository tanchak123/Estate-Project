package com.ithillel.service;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.dao.interfaces.ClientDao;
import com.ithillel.model.Client;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements ClientService {

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        super(clientDao);
    }
}
