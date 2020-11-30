package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends CustomDao<Client, Long> {
}
