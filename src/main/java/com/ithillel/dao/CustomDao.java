package com.ithillel.dao;

import com.ithillel.model.Region;

import java.util.List;

public interface CustomDao<C, L> {

    public void add(C instance);

    public C get(L id);

    public List<C> getAll();

    public C update(L id);

    public C delete(L id);
}
