package com.ithillel.dao.generic;

import com.ithillel.model.Client;
import com.ithillel.model.history.History;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface CustomDao<C, L> extends CrudRepository<C, L> {

    @Query("from #{#entityName} c where c.id = :id")
    C get(@Param("id") L id);

    @Query("from #{#entityName}")
    List<C> getAll();

    @Modifying
    <S extends C> S save(S var1);


    @Modifying
    void delete(C instance);

    Page<C> findAllByOrderById(Pageable pageable);

}
