package com.ithillel.service.interfaces;

import com.ithillel.model.history.History;
import com.ithillel.service.generic.CustomService;

import java.sql.Timestamp;

public interface HistoryService extends CustomService<History, Long> {

//    void callDeleteProcedure(Timestamp date);
//
//    void callDeleteProcedureNative(Timestamp date);
//
//    void callDeleteProcedureTemplate(Timestamp date);

    void deleteAllByCreateDateBefore(Long date);
}
