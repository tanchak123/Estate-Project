package com.ithillel.service.interfaces;

import com.ithillel.model.Client;
import com.ithillel.service.generic.interfaces.CustomService;
import com.ithillel.service.generic.interfaces.IteratorCustomService;

public interface ClientService extends CustomService<Client, Long>, IteratorCustomService<Client> {
}
