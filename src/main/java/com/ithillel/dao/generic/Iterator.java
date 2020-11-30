package com.ithillel.dao.generic;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface Iterator<C> extends IteratorCustom<C> {

}
