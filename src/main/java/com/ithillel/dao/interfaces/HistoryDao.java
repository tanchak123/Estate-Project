package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.history.History;

import java.sql.Timestamp;

public interface HistoryDao extends CustomDao<History, Long> {

    void callDeleteProcedure(Timestamp date);

    void callDeleteProcedureNative(Timestamp date);

    void callDeleteProcedureTemplate(Timestamp date);
}
