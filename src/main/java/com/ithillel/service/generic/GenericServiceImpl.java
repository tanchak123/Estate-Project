package com.ithillel.service.generic;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.generic.CustomModel;
import com.ithillel.model.generic.GetId;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
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
        Assert.notNull(c, "instance is null");
        return customDao.create(c);
    }

    @Override
    public C deleteById(final L id) {
        Assert.notNull(id, "id is null");
        C instance = getById(id);
        return delete(instance);
    }

    @Override
    public C updateById(final L id) {
        Assert.notNull(id, "id is null");
        return customDao.update(getById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public C getById(final L id) {
        Assert.notNull(id, "Id is null");
        C instance = customDao.get(id);
        Assert.notNull(instance, "Can't get instance with id = " + id);
        return instance;
    }

    @Override
    @Transactional(readOnly = true)
    public C eagerGetById(final L id) {
        Assert.notNull(id, "Id is " + id);
        C instance = getById(id);
        Assert.notNull(instance, "Can't get instance with id = " + id);
            Field[] fields1 = instance.getClass().getDeclaredFields();
            for (Field field : fields1) {
                String fieldName = field.getName();
                if (fieldName.endsWith("List")) {
                    field.setAccessible(true);
                    try {
                        List<? super CustomModel> list = new ArrayList<>
                                ((Collection<? super CustomModel>) field.get(instance));
                        list.size();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        return instance;
    }

    @Override
    public C delete(final C c) {
        Assert.notNull(c, "instance is null");
        GetId getId = (GetId) c;
        C instance = getById((L) getId.getId());
        System.out.println(instance.toString());
        return customDao.delete(instance);
    }

    @Override
    public C cascadeDelete(final C c) {
        Assert.notNull(c, "instance is null");
        GetId getId = (GetId) c;
        C instance = getById((L) getId.getId());
        System.out.println(instance.toString());
        cascadeDeleteFunction(instance);
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

    private static <V>ArrayList getGenericList(final V instance, final String mainModelName)
            throws IllegalAccessException {
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


    private <V>void cascadeDeleteFunction(final C instance) {
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
                        System.out.println(innerInstance);
                        ArrayList<C> innerInstanceList = getGenericList(innerInstance, name);
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
}
