package com.lcvinh.demo.base;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class BaseDao<T> {

    @PersistenceContext(unitName = "MyPU")
    protected EntityManager em;

    private Class<T> entityClass;

    // Constructor that receives the entity class type
    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    // Create (Insert) and return the persisted entity
    @Transactional
    public T save(T entity) {
        em.persist(entity);
        return entity;
    }

    // Read (Find by ID)
    public Optional<T> findById(UUID id) {
        T entity = em.find(entityClass, id);
        return Optional.ofNullable(entity);
    }

    // Read (Find all)
    public List<T> findAll() {
        return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
    }

    // Update (Merge) and return the updated entity
    @Transactional
    public T update(T entity) {
        return em.merge(entity);
    }

    // Delete (Remove)
    @Transactional
    public void delete(UUID id) {
        Optional<T> entity = findById(id);
        entity.ifPresent(e -> em.remove(e));
    }
}
