package com.ithillel.service.generic;

import com.ithillel.dao.generic.CustomDao;
import com.ithillel.model.generic.GetId;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Transactional(propagation = Propagation.REQUIRED)
public abstract class GenericServiceImpl<C, L> implements CustomService<C, L> {

    private final CustomDao<C, L> customDao;

    public GenericServiceImpl(final CustomDao<C, L> customDao) {
        this.customDao = customDao;
    }

    @Override
    public C create(final C c) {
        return customDao.create(c);
    }

    @Override
    public C deleteById(final L id) {
        return customDao.delete(getById(id));
    }

    @Override
    public C updateById(final L id) {
        return customDao.update(getById(id));
    }

    @Override
    public C getById(final L id) {
        C instance = customDao.get(id);
        Assert.notNull(instance, "Can't get instance with id " + id);
        return instance;
    }

    @Override
    public C delete(final C c) {
        GetId id = (GetId) c;
        C instance = getById((L) id.getId());
        return customDao.delete(instance);
    }

    @Override
    public C update(final C c) {
        return (C) customDao.update(c);
    }

    @Override
    public List<C> getAll() {
        return customDao.getAll();
    }

    public CustomDao<C, L> getCustomDao() {
        return customDao;
    }
}
