package com.ithillel.dao;

import com.ithillel.dao.generic.GenericDaoImpl;
import com.ithillel.dao.interfaces.HistoryDao;
import com.ithillel.model.history.History;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

@Repository
@Transactional
public class HistoryDaoImpl extends GenericDaoImpl<History, Long> implements HistoryDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public HistoryDaoImpl(History history) {
        super(history);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void callDeleteProcedureNative(Timestamp date) {
        Query x = entityManager.createNativeQuery("select * from delete_all_by_date(?)")
                .setParameter(1, date);
        System.out.println("NATIVE :: " + x.getSingleResult());
    }

    @Override
    public void callDeleteProcedureTemplate(Timestamp date) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withFunctionName("delete_all_by_date");
        System.out.println("TEMPLATE :: " + jdbcCall.execute(new MapSqlParameterSource().addValue("given_date", date)));
//        System.out.println(jdbcCall.executeFunction(Timestamp.class ,new MapSqlParameterSource()
//                        .addValue("given_date", date)));
//        jdbcCall.execute(date);
    }

    public void callDeleteProcedure(Timestamp date) {
//        entityManager.unwrap(Session.class).doWork((connection) ->
//        {
//            try (CallableStatement function = connection.prepareCall("{" +
//                    "call delete_all_by_date(?)}")) {
//                function.setTimestamp(1, date);
//                function.execute();
//            }
//        });
        System.out.println("Named :: " + entityManager.createNamedStoredProcedureQuery("deleteHistoryByDate")
                .setParameter(1, date).execute());

    }
}
