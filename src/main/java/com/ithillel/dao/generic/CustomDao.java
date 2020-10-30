package com.ithillel.dao.generic;

import com.ithillel.model.Region;

import java.util.List;

public interface CustomDao<C, L> {

    void add(C instance);

    public C get(L id);

    public List<C> getAll();

    public C update(C instance);

    public C delete(C instance);

}
