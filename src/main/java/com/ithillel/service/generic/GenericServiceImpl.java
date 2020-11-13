package com.ithillel.service.generic;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.generic.GetId;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Transactional(propagation = Propagation.REQUIRED)
public abstract class GenericServiceImpl<C, L> implements CustomService<C, L> {

    protected final CustomDao<C, L> customDao;

    public GenericServiceImpl(final CustomDao<C, L> customDao) {
        Assert.notNull(customDao, "Can't get dao with name " + customDao);
        this.customDao = customDao;
    }

    @Override
    public C create(final C c) {
        Assert.notNull(c, "Can't get instance = " + c);
        return customDao.create(c);
    }

    @Override
    public C deleteById(final L id) {
        Assert.notNull(id, "Can't get instance with id = " + id);
        return customDao.delete(getById(id));
    }

    @Override
    public C updateById(final L id) {
        Assert.notNull(id, "Can't get instance with id = " + id);
        return customDao.update(getById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public C getById(final L id) {
        C instance = customDao.get(id);
        Assert.notNull(instance, "Can't get instance with id = " + id);
        return instance;
    }

    @Override
    public C delete(final C c) {
        Assert.notNull(c, "Can't delete instance = " + c);
        GetId id = (GetId) c;
        C instance = getById((L) id.getId());
        return customDao.delete(instance);
    }

    @Override
    public C update(final C c) {
        Assert.notNull(c, "Can't update instance = " + c);
        return customDao.update(c);
    }

    @Override
    @Transactional(readOnly = true)
    public List<C> getAll() {
        return customDao.getAll();
    }

//    private <K> void clearEstateAgencies(List<K> instances, C c) {
//        for (K k : instances) {
//            List<C> realtorList;
//            try {
//                Method method = k.getClass().getDeclaredMethod("getRealtorList");
//                method.setAccessible(true);
//                realtorList = (List<C>) method.invoke(method);
//            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//            List<C> result = new ArrayList<>();
//            for (C listC : realtorList) {
//                GetId getIdC = (GetId) c;
//                GetId getIdListC = (GetId) listC;
//                if (!getIdListC.getId().equals(getIdC.getId())) {
//                    result.add(rl);
//                }
//            }
//            eA.setRealtorList(result);
//        }
//        realtor.setEstateAgency(null);
//    }
//
//    public static void main(String[] args) {
//        EstateAgency estateAgency = new EstateAgency();
//        Realtor sanya = new Realtor();
//        sanya.setName("fdasfas");
//        Realtor sanya1 = new Realtor();
//        sanya.setName("fdasfasfdas");
//        estateAgency.setRealtorList(new ArrayList<>(List.of(sanya1, sanya)));
//        List<Realtor> realtorList;
//        try {
//            Field[] fields = estateAgency.getClass().getDeclaredFields();
//            for (Field field : fields) {
//                String name = field.getName();
//                if (name.endsWith("List")) {
//                    for (Annotation annotation : field.getAnnotations()) {
//                        if (annotation.toString().contains("ManyToMany")) {
//                            field.setAccessible(true);
//                            Object o = field.get(name);
//                        }
//
//                    }
//                    System.out.println(estateAgency.getClass());
//                    System.out.println(field.toString());
//                }
//            }
//            Method method = estateAgency.getClass().getDeclaredMethod("getRealtorList");
//            method.setAccessible(true);
//            realtorList = (List<Realtor>) method.invoke(method);
//        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }

}
