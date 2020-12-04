package com.ithillel.utils.interfaces;

import com.ithillel.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UtilsInterfaces<T> {
    Page<T> getAllByValueOrderById(String name, String value, Pageable page, Long count);
}
