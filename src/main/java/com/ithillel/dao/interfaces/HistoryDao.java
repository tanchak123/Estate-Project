package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.dao.generic.intefaces.IteratorCustomDao;
import com.ithillel.model.history.History;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface HistoryDao extends CustomDao<History, Long>, IteratorCustomDao<History> {

//    void callDeleteProcedure(Timestamp date);

//    @Modifying
//    @Query(value = "call delete_all_by_date((:given_date):::timestamp);", nativeQuery = true)
//    void removeAllByCreateDateIsLessThan(@Param("given_date") Long date);

    @Procedure
    void delete_all_by_date(Timestamp date);

//    void callDeleteProcedureNative(Timestamp date);
//
//    void callDeleteProcedureTemplate(Timestamp date);

//    List<History> findAllByOrderByIdAsc(String columnName);
//
//    List<History> getBetWeen(String columnName, Long from, Long to);
//
//    List<History> getBetweenTimeStamp(String valueName, Timestamp from, Timestamp too);
//
//    List<History> findAllByBetween(String columnName, Long from, Long to);
}
