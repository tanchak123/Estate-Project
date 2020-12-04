package com.ithillel.service;

import com.ithillel.dao.interfaces.HistoryDao;
import com.ithillel.model.history.History;
import com.ithillel.service.generic.GenericServiceImpl;
import com.ithillel.service.interfaces.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class HistoryServiceImpl extends GenericServiceImpl<History, Long>
        implements HistoryService {

    @Autowired
    History history;

    private HistoryDao historyDao;

    @Autowired
    public HistoryServiceImpl(HistoryDao historyDao) {
        super(historyDao);
        this.historyDao = historyDao;
    }

//    @Override
//    @Transactional
//    public void callDeleteProcedure(Timestamp date) {
//        historyDao.callDeleteProcedure(date);
//    }
//
//    @Override
//    public void callDeleteProcedureNative(Timestamp date) {
//        historyDao.callDeleteProcedureNative(date);
//    }
//
//    @Override
//    public void callDeleteProcedureTemplate(Timestamp date) {
//        historyDao.callDeleteProcedureTemplate(date);
//    }

    @Transactional
    @Override
    public void deleteAllByCreateDateBefore(Long date) {
        historyDao.delete_all_by_date(Timestamp.from(Instant.ofEpochMilli(date)));
    }

    @Override
    public Page<History> getAllByValueOrderById(String name, String value, Pageable page, Long count) {
        return historyDao.getAllByValueOrderById(history , name, value, page, count);
    }
}
