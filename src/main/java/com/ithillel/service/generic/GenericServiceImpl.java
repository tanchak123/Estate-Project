package com.ithillel.service.generic;

import com.ithillel.appcontext.ApplicationContext;
import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.EstateAgency;
import com.ithillel.model.Realtor;
import com.ithillel.model.generic.GetId;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.ithillel.service.interfaces.RealtorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        C instance = getById(id);
        Assert.notNull(id, "Can't get instance with id = " + id);
        return delete(instance);
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
        GetId getId = (GetId) c;
        C instance = getById((L) getId.getId());
        System.out.println(instance.toString());
        cascadeDelete(instance);
        return customDao.delete(c);
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

    private static <V>ArrayList getList(final V instance, final String mainModelName) throws IllegalAccessException {
        Field[] fields1 = instance.getClass().getDeclaredFields();
        for (Field field : fields1) {
            char zeroCharName = mainModelName.charAt(0);
            String fieldName = field.getName();
            if (fieldName.endsWith("List") && fieldName.startsWith(mainModelName.replaceAll(
                    "[" + zeroCharName + "]",
                    (zeroCharName + "").toLowerCase()
            ))) {
                field.setAccessible(true);
                return new ArrayList<>((Collection<? extends V>) field.get(instance));
            }
        }
        return null;
    }


    private <V>void cascadeDelete(final C instance) {
        String name = instance.getClass().getSimpleName();
        try {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();
                if (fieldName.endsWith("List")) {
                    System.out.println(field.getName());
                    field.setAccessible(true);
                    List<V> innerList = new ArrayList<>((Collection<? extends V>) field.get(instance));
                    for (V innerInstance : innerList) {
                        ArrayList<C> innerInstanceList = getList(innerInstance, name);
                        ArrayList<C> result = new ArrayList<>();
                        for (C instanceList : innerInstanceList) {
                            GetId insId = (GetId) instance;
                            GetId instLId = (GetId) instanceList;
                            if (!instLId.getId().equals(insId.getId())) {
                                result.add(instanceList);
                            }
                        }
                        Field[] fields1 = innerInstance.getClass().getDeclaredFields();
                        for (Field field1 : fields1) {
                            String fieldName1 = field1.getName();
                            if (fieldName1.equals(
                                    (name.charAt(0) + "").toLowerCase() +
                                            name.substring(1)
                                    + "List"
                            )) {
                        field1.setAccessible(true);
                        field1.set(innerInstance, result);
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(ApplicationContext.class);
        RealtorService realtorService = (RealtorService)
                annotationConfigApplicationContext.getBean("realtorServiceImpl");
        Realtor realtor = realtorService.getById(27L);
        Field[] fields = realtor.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getDeclaringClass());
            field.setAccessible(true);
            System.out.println(field.get(realtor));
        }

    }
}
