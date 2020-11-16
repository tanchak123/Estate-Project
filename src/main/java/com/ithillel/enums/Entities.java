package com.ithillel.enums;
import java.util.ArrayList;
import java.util.List;

enum EntitiesList {
    REALTOR;

//    private List<?> rl;
//
//    REALTOR(List<Realtor> rl = new ArrayList<>())
//
//    public EntitiesList (List<?> list) {
//        this.rl
//    }

    public static <T> void main(String[] args) {
        List<T> list = new ArrayList<>();
        list.add((T) "AFSDAFASD");
        System.out.println(list.get(0));
        Integer a = 12313;
        list.add((T) a);
        System.out.println(list.get(1));
    }

}
