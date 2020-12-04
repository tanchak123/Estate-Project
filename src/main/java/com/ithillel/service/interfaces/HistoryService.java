package com.ithillel.service.interfaces;

import com.ithillel.model.Client;
import com.ithillel.model.history.History;
import com.ithillel.service.generic.interfaces.CustomService;
import com.ithillel.service.generic.interfaces.IteratorCustomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoryService extends CustomService<History, Long>, IteratorCustomService<History> {

//    void callDeleteProcedure(Timestamp date);
//
//    void callDeleteProcedureNative(Timestamp date);
//
//    void callDeleteProcedureTemplate(Timestamp date);

    void deleteAllByCreateDateBefore(Long date);

}
