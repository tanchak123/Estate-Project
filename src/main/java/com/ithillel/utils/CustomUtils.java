package com.ithillel.utils;

import com.ithillel.model.customodel.GetId;
import com.ithillel.service.generic.interfaces.IteratorCustomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomUtils {

    public static Predicate getEqualExpression(CriteriaBuilder cb, Root root, String[] mass, String value) {
        Predicate expression = cb.equal(root.get(mass[0]), value);
        if (mass.length > 1) {
            expression = cb.equal(root.get(mass[0]).get(mass[1]), value);
        }
        return expression;
    }

    public static <T>void testPageable(String name, String value, IteratorCustomService<T> utilsInterface,
                                       PageRequest pageRequest) {
        Page<T> clients = utilsInterface.getAllByValueOrderById(name, value,
                pageRequest, null);
        while (clients.hasNext()) {
            for (T c : clients.getContent()) {
                System.out.println(((GetId)c).getId());
            }
            clients = utilsInterface.getAllByValueOrderById( name, value,
                    clients.nextPageable(), clients.getTotalElements());
        }
        for (T c : clients.getContent()) {
            System.out.println(((GetId)c).getId());
        }
    }
}
