package com.ithillel.service.interfaces;

import com.ithillel.model.EstateAgency;
import com.ithillel.service.generic.interfaces.CustomService;
import com.ithillel.service.generic.interfaces.IteratorCustomService;

public interface EstateAgencyService extends CustomService<EstateAgency, Long>,
        IteratorCustomService<EstateAgency> {
}
