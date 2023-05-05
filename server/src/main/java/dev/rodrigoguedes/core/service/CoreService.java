package dev.rodrigoguedes.core.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import dev.rodrigoguedes.core.domain.CoreEntity;
import dev.rodrigoguedes.core.repository.CoreRepository;
import jakarta.persistence.EntityManager;

@Transactional
public class CoreService<T extends CoreEntity<K>, K extends Serializable> {

    @Autowired
    private CoreRepository<T, K> repository;

    @Autowired
    private EntityManager entityManager;

    public CoreRepository<T, K> getRepository() {
        return this.repository;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void setRepository(CoreRepository<T, K> repository) {
        this.repository = repository;
    }

    public Page<T> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Transactional
    public T save(T entity) {
        if (isNew(entity)) {
            beforeInsert(entity);
        } else {
            beforeUpdate(entity);
        }

        T saved = this.getRepository().save(entity);

        afterSave(entity);

        return saved;
    }

    protected void beforeInsert(T entity) {
    }

    protected void beforeUpdate(T entity) {
    }

    protected void afterSave(T entity) {
    }

    protected boolean isNew(T entity) {
        return entity.isNew();
    }

    public void delete(T entity) {
        this.getRepository().delete(entity);
        this.getRepository().flush();
    }

}
