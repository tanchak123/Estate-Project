package com.ithillel.dao.generic;

import java.util.List;

public interface CustomDao<C, L> {

    C create(C instance);

    public C get(L id);

    public List<C> getAll();

    public C update(C instance);

    public C delete(C instance);

}
