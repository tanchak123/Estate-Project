package com.ithillel.dao;

import com.ithillel.dao.generic.GenericDaoImpl;
import com.ithillel.dao.interfaces.HistoryDao;
import com.ithillel.model.history.History;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.Timestamp;

@Repository
@Transactional
public class HistoryDaoImpl extends GenericDaoImpl<History, Long> implements HistoryDao {

    @Autowired
    public HistoryDaoImpl(History history) {
        super(history);
    }

    public void callDeleteProcedure(Timestamp date) {
        ProcedureCall delete_all_by_date = entityManager.unwrap(Session.class).createStoredProcedureCall("delete_all_by_date");
        delete_all_by_date
                .registerStoredProcedureParameter("given_date", Timestamp.class, ParameterMode.INOUT)
                .setParameter("given_date", date);
        delete_all_by_date.execute();
    }

}
