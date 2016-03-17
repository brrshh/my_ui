package bel.core.service;

import bel.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by Shlyaga_BA on 29.01.2016.
 */
@NoRepositoryBean
public abstract class AbstratGenericService<T, ID extends Serializable> implements PagingAndSortingRepository<T, ID> {

    @Autowired
    PagingAndSortingRepository<T, ID> repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = false)
    public <S extends T> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        return repository.save(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public T findOne(ID pId) {
        return repository.findOne(pId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(ID pId) {
        return repository.exists(pId);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<T> findAll(Iterable<ID> pIds) {
        return repository.findAll(pIds);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return repository.count();
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(ID aLong) {
        repository.delete(aLong);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Iterable<? extends T> entities) {
        repository.delete(entities);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteAll() {
        repository.deleteAll();
    }
}
