package com.ithillel.dao;

import com.ithillel.model.Region;

public interface CustomDao<C, L> {

    public void add(C instance);

    public void get(L id);

    public void getAll();

    public void update(L id);

    public void delete(L id);
}
