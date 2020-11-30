package com.ithillel.dao.interfaces;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.Region;
import com.ithillel.model.history.History;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface HistoryDao extends CustomDao<History, Long> {

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
