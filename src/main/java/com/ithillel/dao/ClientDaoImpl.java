package com.ithillel.dao;

import com.ithillel.dao.generic.GenericDaoImpl;
import com.ithillel.dao.interfaces.ClientDao;
import com.ithillel.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client, Long> implements ClientDao {

    @Autowired
    public ClientDaoImpl(Client client) {
        super(client);
    }
}
