package com.ithillel.service.generic;

import java.util.List;

public interface CustomService<C, L> {

    C create(C c);

    C deleteById(L l);

    C updateById(L l);

    C getById(L l);

    C delete(C c);

    C update(C c);

    List<C> getAll();
}
