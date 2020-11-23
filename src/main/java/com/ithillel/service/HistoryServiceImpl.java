package com.ithillel.service;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.dao.interfaces.HistoryDao;
import com.ithillel.model.history.History;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class HistoryServiceImpl extends GenericServiceImpl<History, Long> implements HistoryService {

    private HistoryDao historyDao;

    @Autowired
    public HistoryServiceImpl(HistoryDao historyDao) {
        super(historyDao);
        this.historyDao = historyDao;
    }

    @Override
    @Transactional
    public void callDeleteProcedure(Timestamp date) {
        historyDao.callDeleteProcedure(date);
    }

    @Override
    public void callDeleteProcedureNative(Timestamp date) {
        historyDao.callDeleteProcedureNative(date);
    }

    @Override
    public void callDeleteProcedureTemplate(Timestamp date) {
        historyDao.callDeleteProcedureTemplate(date);
    }
}
